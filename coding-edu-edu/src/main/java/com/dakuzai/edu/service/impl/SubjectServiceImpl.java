package com.dakuzai.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dakuzai.edu.entity.Subject;
import com.dakuzai.edu.mapper.SubjectMapper;
import com.dakuzai.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dakuzai.edu.vo.SubjectNestedVo;
import com.dakuzai.edu.vo.SubjectVo;
import com.dakuzai.utils.ExcelImportUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-05
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    // 事务处理
    @Transactional
    @Override
    public List<String> batchImport(MultipartFile file) throws Exception {

        // 处理失败消息封装
        List<String> errorMsg = new ArrayList<>();

        // 获取工作表
        ExcelImportUtil excelHSSFUtil = new ExcelImportUtil(file.getInputStream());
        HSSFSheet sheet = excelHSSFUtil.getSheet();

        int rowCount = sheet.getPhysicalNumberOfRows();
        if (rowCount <= 1){
            errorMsg.add("请填写数据");
            return errorMsg;
        }
        // 遍历获取数据 (父-子，写入数据库！)
        for (int rowNum = 0; rowNum < rowCount ; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData!=null){ // 行中存在内容
                // 获取一级分类  pid 0
                String levelOneValue = "";
                Cell levelOneCell = rowData.getCell(0);
                if (levelOneCell!=null){
                    levelOneValue = excelHSSFUtil.getCellValue(levelOneCell).trim();
                    if (StringUtils.isEmpty(levelOneValue)){
                        errorMsg.add("第"+ rowNum + "行一级分类为空");
                        continue;
                    }
                }

                // 判断一级分类是否重复
                Subject subject = this.getByTitle(levelOneValue);
                String parentId = null;
                if (subject == null){
                    // 将一级分类插入到数据库
                    Subject subjectLevelOne = new Subject();
                    subjectLevelOne.setTitle(levelOneValue);
                    subjectLevelOne.setSort(rowNum);
                    baseMapper.insert(subjectLevelOne); // 添加
                    // 回调父id
                    parentId = subjectLevelOne.getId();
                }else {
                    parentId = subject.getId();
                }

                // 获取二级分类
                String levelTwoValue = "";
                Cell levelTwoCell = rowData.getCell(1);
                if (levelTwoCell!=null){
                    levelTwoValue = excelHSSFUtil.getCellValue(levelTwoCell).trim();
                    if (StringUtils.isEmpty(levelTwoValue)){
                        errorMsg.add("第"+ rowNum + "行二级分类为空");
                        continue;
                    }
                }

                // 判断二级分类是否重复
                Subject subjectSub = this.getSubByTitle(levelTwoValue, parentId);
                Subject subjectLevelTwo = null;
                if (subjectSub == null){
                    // 将二级分类插入到数据库
                    subjectLevelTwo = new Subject();
                    subjectLevelTwo.setTitle(levelTwoValue);
                    subjectLevelTwo.setParentId(parentId);
                    subjectLevelTwo.setSort(rowNum);
                    baseMapper.insert(subjectLevelTwo); // 添加
                }

            }
        }

        return errorMsg;
    }

    @Override
    public List<SubjectNestedVo> nestedList() {
        // 返回的数据
        ArrayList<SubjectNestedVo> subjectNestedVoArrayList = new ArrayList<>();

        // 获取一级分类
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",0);
        queryWrapper.orderByAsc("sort","id");
        List<Subject> subjects = baseMapper.selectList(queryWrapper);
        // 获取二级分类 TODO
        QueryWrapper<Subject> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.ne("parent_id",0); // 二级
        queryWrapper2.orderByAsc("sort","id");
        List<Subject> subSubjects = baseMapper.selectList(queryWrapper2);

        // 填充一级分类值 VO
        int count = subjects.size();
        for (int i = 0; i < count; i++) {
            Subject subject = subjects.get(i);
            // 封装视图对象
            SubjectNestedVo subjectNestedVo = new SubjectNestedVo(); // 带节点的List
            // 技巧（拷贝）, 假设如果存在多个值，直接拷贝即可
            BeanUtils.copyProperties(subject,subjectNestedVo);
            subjectNestedVoArrayList.add(subjectNestedVo);

            // 填充二级分类值 TODO
            ArrayList<SubjectVo> subjectVoArrayList = new ArrayList<>();
            int count2 = subSubjects.size();
            for (int j = 0; j < count2 ; j++) {
                Subject subSubject = subSubjects.get(j);
                if (subject.getId().equals(subSubject.getParentId())){ // 确定父子关系
                    SubjectVo subjectVo = new SubjectVo();
                    BeanUtils.copyProperties(subSubject,subjectVo);
                    subjectVoArrayList.add(subjectVo);
                }
            }
            subjectNestedVo.setChildren(subjectVoArrayList); // 嵌套显示！
        }

        return subjectNestedVoArrayList;
    }
    // 删除实现类


    // 判断一级分类是否重复
    private Subject getByTitle(String title){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",title);
        queryWrapper.eq("parent_id","0"); // 一级分类
        return baseMapper.selectOne(queryWrapper);
    }

    // 判断二级分类是否重复
    private Subject getSubByTitle(String title,String parentId){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",title);
        queryWrapper.eq("parent_id",parentId);
        return baseMapper.selectOne(queryWrapper);
    }

}

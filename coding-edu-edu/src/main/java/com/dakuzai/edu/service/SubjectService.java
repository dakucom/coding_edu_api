package com.dakuzai.edu.service;

import com.dakuzai.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dakuzai.edu.vo.SubjectNestedVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Coding
 * @since 2020-04-05
 */
public interface SubjectService extends IService<Subject> {
    // 批量导入excel表中的数据 （父id  子id）
    List<String> batchImport(MultipartFile file) throws Exception;
    // 获取节点
    List<SubjectNestedVo> nestedList();
    // 删除方法

}

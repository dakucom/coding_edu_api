package com.dakuzai.edu.controller.admin;
/**
 * .::::.
 * .::::::::.
 * :::::::::::    永无Bug、阿门
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 **/

import com.dakuzai.common.constants.ResultCodeEnum;
import com.dakuzai.common.handler.CodingException;
import com.dakuzai.common.vo.R;
import com.dakuzai.edu.service.SubjectService;
import com.dakuzai.edu.vo.SubjectNestedVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *@program: coding_edu_api
 *@description: 课程分类管理
 *@author: dakuzai
 *@create: 2020-05-11 16:58
 */
@Api(tags = "课程分类管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/edu/subject")
public class SujectAdminController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation(value = "Excel信息批量录入到数据库")
    @PostMapping("import")
    public R batchImport(
            @ApiParam(name = "file",value = "Excel文件",required = true)
            @RequestParam MultipartFile file){

        try {
            List<String> errorMsg = subjectService.batchImport(file);
            if (errorMsg.size() == 0){
                return R.ok().message("批量导入成功！");
            }else {
                return R.error().message("部分数据导入失败").data("errorMsgList",errorMsg);
            }
        } catch (Exception e) {
            // 无论什么异常，都使用我们的统一异常进行处理
            throw new CodingException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
        }

    }


    @ApiOperation(value = "嵌套数据列表")
    @GetMapping("")
    public R nestedList(){
        List<SubjectNestedVo> subjectNestedVoList = subjectService.nestedList();
        return R.ok().data("items",subjectNestedVoList);
    }

    // 删除请求
}

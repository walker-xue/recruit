package com.ncs.recruit.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.skunk.web.HttpParamUtils;
import com.ncs.recruit.context.system.DictionaryService;
import com.ncs.recruit.context.system.dto.DictValuesDto;
import com.ncs.recruit.context.system.model.Dictionary;
import com.ncs.recruit.interfaces.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 应聘者的简历
 *
 * @author walker
 */
@Api(tags = "系统词典")
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController extends BaseController {

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 词典值列表
     *
     * @param dictKey
     * @return
     */
    @GetMapping("/values")
    @ApiOperation(value = "词典值列表", notes = "根据词典Key获取词典值列表")
    public List<DictValuesDto> list(@ApiParam(value = "词典Key值") @RequestParam String dictKey) {
        return dictionaryService.getKeyValues(dictKey);
    }



    /**
     * 词典列表
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "词典列表", notes = "词典列表")
    public List<Dictionary> page() {
        return dictionaryService.selectList(HttpParamUtils.listFilter(request));
    }
}

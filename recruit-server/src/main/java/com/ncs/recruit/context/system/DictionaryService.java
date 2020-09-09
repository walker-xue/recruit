package com.ncs.recruit.context.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import com.github.skunk.core.collectors.CollectorUtils;
import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.system.dto.DictValuesDto;
import com.ncs.recruit.context.system.mapper.DictionaryMapper;
import com.ncs.recruit.context.system.model.Dictionary;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class DictionaryService extends BaseService<Dictionary> {

    @Resource
    DictionaryMapper dictionaryMapper;

    /**
     * @param dictKey
     * @return
     */
    public List<DictValuesDto> getKeyValues(@NotBlank String dictKey) {

        Validate.notBlank(dictKey);

        Weekend<Dictionary> weekend = new Weekend<>(Dictionary.class);
        WeekendCriteria<Dictionary, Object> keywordCriteria = weekend.weekendCriteria();
        keywordCriteria.andEqualTo(Dictionary::getBlock, dictKey);

        weekend.selectProperties("code", "value");
        List<Dictionary> dictionaries = mapper.selectByExample(weekend);
        if (CollectorUtils.isEmpty(dictionaries)) {
            return Collections.emptyList();
        }
        return dictionaries.stream().map(dict -> new DictValuesDto(dict.getCode(), dict.getValue())).collect(Collectors.toList());
    }

    /**
     * 查询简历的状态，目的是为了获得每个状态的天数
     *
     * @param resumeState
     * @return
     */
    public List<Dictionary> findOptionForResumState(String resumeState) {
        List<Dictionary> dictionaryForResumList = new ArrayList<Dictionary>();

        try {
            dictionaryForResumList = dictionaryMapper.selectDictionary(resumeState);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dictionaryForResumList;
    }

}

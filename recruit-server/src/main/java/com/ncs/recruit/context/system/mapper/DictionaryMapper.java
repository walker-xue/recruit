package com.ncs.recruit.context.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.skunk.data.utils.BasisMapper;
import com.ncs.recruit.context.system.model.Dictionary;

@Repository
public interface DictionaryMapper extends BasisMapper<Dictionary> {

    List<Dictionary> selectDictionary(String typeInfo);

}
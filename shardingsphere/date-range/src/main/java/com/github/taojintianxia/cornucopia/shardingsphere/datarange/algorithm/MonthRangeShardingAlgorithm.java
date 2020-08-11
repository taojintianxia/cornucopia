package com.github.taojintianxia.cornucopia.shardingsphere.datarange.algorithm;

import com.github.taojintianxia.cornucopia.shardingsphere.datarange.util.DateRangeShardingUtil;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nianjun Sun
 */
public class MonthRangeShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
            ComplexKeysShardingValue<Long> shardingValue) {
        Set<String> result = new LinkedHashSet<>();
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = shardingValue
                .getColumnNameAndShardingValuesMap();
        Map<String, Range<Long>> columnNameAndRangeValuesMap = shardingValue.getColumnNameAndRangeValuesMap();
        if (!columnNameAndShardingValuesMap.isEmpty()) {
            columnNameAndShardingValuesMap.forEach((key, value) -> {
                value.forEach(time -> {
                    result.add(shardingValue.getLogicTableName() + "_" + DateRangeShardingUtil.getToMonthFromTime(time));
                });
            });
        } else if (!columnNameAndRangeValuesMap.isEmpty()) {

        }

        return result;
    }
}

package com.github.taojintianxia.cornucopia.shardingsphere.datarange.algorithm.database;

import com.github.taojintianxia.cornucopia.shardingsphere.datarange.util.DateRangeShardingUtil;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author Nianjun Sun
 */
public final class PreciseYearlyShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<Long> shardingValue) {
        String year = DateRangeShardingUtil.getToYearFromTime(shardingValue.getValue());
        for (String each : databaseNames) {
            if (each.endsWith(year)) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}

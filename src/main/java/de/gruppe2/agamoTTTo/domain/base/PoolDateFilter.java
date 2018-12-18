package de.gruppe2.agamoTTTo.domain.base;

import de.gruppe2.agamoTTTo.domain.entity.Pool;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

/**
 * Used for filtering entities which contain pools and dates (e.g. Records, RecordLogs)
 */
@Getter
@Setter
@NoArgsConstructor
public class PoolDateFilter {

    private Pool pool;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;

    public PoolDateFilter(LocalDate today) {
        LocalDate oneMonthAgo = today.minus(Period.ofMonths(1));
        this.from = oneMonthAgo.withDayOfMonth(1);
        this.to = oneMonthAgo.withDayOfMonth(oneMonthAgo.lengthOfMonth());
    }
}
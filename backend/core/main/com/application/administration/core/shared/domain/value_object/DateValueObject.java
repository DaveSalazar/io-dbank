package com.application.administration.core.shared.domain.value_object;

import com.application.administration.core.shared.domain.errors.InvalidDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class DateValueObject {
    private Date value;

    public DateValueObject(String value) {
        try {
            if(value != null && !value.isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                this.value = formatter.parse(value);
            }
        }catch (ParseException e) {
            throw new InvalidDateFormat(value);
        }catch (Exception e) {
            throw e;
        }
    }

    public Date value() {
        return value;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(this.value());
        return strDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DateValueObject)) {
            return false;
        }
        DateValueObject that = (DateValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

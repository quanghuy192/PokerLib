package vn.hn.quanghuy.out;

import vn.hn.quanghuy.model.ResultStatus;

public class ExecuteOutImpl implements ExecuteOut {

    @Override
    public int processOut(final int percent) {

        if (percent <= ResultStatus.ADD.getPercent()) {

            return ResultStatus.ADD.ordinal();
        } else if (percent <= ResultStatus.ADD_ALL.getPercent()
                && percent > ResultStatus.ADD.getPercent()) {

            return ResultStatus.ADD_ALL.ordinal();
        } else if (percent <= ResultStatus.FOLLOW.getPercent()
                && percent > ResultStatus.ADD_ALL.getPercent()) {

            return ResultStatus.FOLLOW.ordinal();
        } else {

            return ResultStatus.DENY.ordinal();
        }

    }

}

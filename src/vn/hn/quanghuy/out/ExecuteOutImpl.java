package vn.hn.quanghuy.out;

import java.util.List;

import vn.hn.quanghuy.model.ResultStatus;
import vn.hn.quanghuy.utils.PercentUtil;

public class ExecuteOutImpl implements ExecuteOut {

    private static final int STATUS_ADD = 0;
    private static final int STATUS_ADD_ALL = 1;
    private static final int STATUS_FOLLOW = 2;
    private static final int STATUS_REJECT = 3;

    @Override
    public int processOut(List<ResultStatus> list) {

        if (null != list || list.size() > 0) {

            int result = PercentUtil.exportRandomValue();

            if (result <= list.get(STATUS_ADD).getPercent()) {

                return list.get(STATUS_ADD).getId();
            } else if (result <= list.get(STATUS_ADD_ALL).getPercent()
                    && result > list.get(STATUS_ADD).getPercent()) {

                return list.get(STATUS_ADD_ALL).getId();
            } else if (result <= list.get(STATUS_FOLLOW).getPercent()
                    && result > list.get(STATUS_ADD_ALL).getPercent()) {

                return list.get(STATUS_FOLLOW).getId();
            } else {

                return list.get(STATUS_REJECT).getId();
            }
        }
        return list.get(STATUS_REJECT).getId();

    }

}

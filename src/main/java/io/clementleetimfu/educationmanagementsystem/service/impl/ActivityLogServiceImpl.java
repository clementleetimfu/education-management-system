package io.clementleetimfu.educationmanagementsystem.service.impl;

import io.clementleetimfu.educationmanagementsystem.mapper.ActivityLogMapper;
import io.clementleetimfu.educationmanagementsystem.pojo.entity.ActivityLog;
import io.clementleetimfu.educationmanagementsystem.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogMapper activityLogMapper;

    @Override
    public Boolean addActivityLog(ActivityLog activityLog) {
        return activityLogMapper.addActivityLog(activityLog) > 0;
    }
}

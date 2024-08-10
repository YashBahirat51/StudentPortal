package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.NoticeRepository;
import com.app.entities.Notice;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice saveNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }
}

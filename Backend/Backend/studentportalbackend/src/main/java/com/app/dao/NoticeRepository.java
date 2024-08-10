package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}

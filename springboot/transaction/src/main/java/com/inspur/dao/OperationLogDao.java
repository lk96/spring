package com.inspur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.domain.OperationLog;

public interface OperationLogDao extends JpaRepository<OperationLog, Long> {
}

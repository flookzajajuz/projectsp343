package com.example.projectend3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // คุณสามารถเพิ่มฟังก์ชันที่กำหนดเองได้ถ้าต้องการ
}

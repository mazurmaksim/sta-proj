package net.students.accounting.service;

import net.students.accounting.entity.StudentGrants;

public interface GrantsService {
    void saveGrant(StudentGrants grants);
    StudentGrants getStudentGrantsByStudentId(Integer id);
    StudentGrants getStudentGrantsByGrants(Double grant);
}

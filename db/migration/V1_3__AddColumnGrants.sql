ALTER TABLE student_grants
ADD COLUMN
    grants double  null;
ALTER TABLE student_grants
    ADD COLUMN
    months   datetime(6) null;

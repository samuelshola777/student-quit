CREATE TABLE IF NOT EXISTS quiz_result (
   id                                   SERIAL PRIMARY KEY,
   number_of_correct_answer             BIGINT,
   number_of_wrong_answer               BIGINT,
   quiz_time                            TIMESTAMP(6),
    submitted                           BOOLEAN,
    student_id                          BIGINT REFERENCES
    students(id)                        ON DELETE SET NULL
    );

CREATE TABLE IF NOT EXISTS quiz_wrong_question (
   quiz_id BIGINT REFERENCES quiz_result(id) ON DELETE SET NULL,
    wrong_question VARCHAR(255)
    );
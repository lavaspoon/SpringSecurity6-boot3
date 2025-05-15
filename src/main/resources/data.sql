-- User 데이터 삽입
INSERT INTO TB_MEMBER (skid, username) VALUES 
('USER001', '홍길동'),
('USER002', '김철수');

-- Role 데이터 삽입
INSERT INTO TB_ROLE (role_name, user_skid) VALUES 
('ROLE_USER', 'USER001'),
('ROLE_ADMIN', 'USER002'); 
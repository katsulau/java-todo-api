CREATE TABLE IF NOT EXISTS todo (
 id CHAR(128) NOT NULL comment 'id',
 title VARCHAR(128) NOT NULL comment 'タイトル',
 is_finished BIT(1) NOT NULL comment '達成フラグ',
 created_at DATETIME NOT NULL comment '作成日時',
 updated_at DATETIME NOT NULL comment '更新日時',
 PRIMARY KEY (id)
)
  comment = 'Todoテーブル'
  /*! engine = InnoDb */;
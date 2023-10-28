CREATE TABLE IF NOT EXISTS laptop(
  id int not null AUTO_INCREMENT,
  manufacturer varchar(100),
  screen_size varchar(100),
  screen_type varchar(100),
  screen_resolution varchar(100),
  has_touch_screen varchar(100),
  processor_name varchar(100),
  physical_cores_num varchar(100),
  clock_speed varchar(100),
  ram_size varchar(100),
  disc_storage_size varchar(100),
  disc_type varchar(100),
  graphic_card_name varchar(100),
  graphic_card_memory varchar(100),
  os_name varchar(100),
  disc_reader varchar(100),
  PRIMARY KEY ( ID )
);
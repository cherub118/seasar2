create table integer_type (integer_col integer);
create table int_type (int_col int);
create table double_type (double_col double);
create table float_type (float_col float);
create table varchar_type (varchar_col varchar);
create table varchar_ignorecase_type (varchar_ignorecase_col varchar_ignorecase);
create table char_type (char_col char);
create table character_type (character_col character);
create table longvarchar_type (longvarchar_col longvarchar);
create table date_type (date_col date);
create table time_type (time_col time);
create table timestamp_type (timestamp_col timestamp);
create table datetime_type (datetime_col datetime);
create table decimal_type (decimal_col decimal);
create table numeric_type (numeric_col numeric);
create table boolean_type (boolean_col boolean);
create table bit_type (bit_col bit);
create table tinyint_type (tinyint_col tinyint);
create table smallint_type (smallint_col smallint);
create table bigint_type (bigint_col bigint);
create table real_type (real_col real);
create table varbinary_type (varbinary_col varbinary);
create table longvarbinary_type (longvarbinary_col longvarbinary);
--create table other_type (other_col other);
--create table object_type (object_col other);

create table schema_info (version integer);
insert into schema_info values(0);
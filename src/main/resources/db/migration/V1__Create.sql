create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table if not exists faculty
(
	faculty_name text not null
		constraint faculty_pk
			primary key
);

alter table faculty owner to postgres;

create table if not exists the_department
(
	the_department_name text not null
		constraint the_department_pk
			primary key,
	faculty text
		constraint the_department_faculty_name_fk
			references faculty
				on update cascade on delete cascade
);

alter table the_department owner to postgres;

create table if not exists groups
(
	number_of_group integer not null
		constraint group_pk
			primary key,
	course integer,
	faculty text
		constraint group_faculty_name_fk
			references faculty
				on update cascade on delete cascade
);

alter table groups owner to postgres;

create table if not exists candidate
(
	candidate_name text not null
		constraint candidate_pk
			primary key,
	date date,
	theme text
);

alter table candidate owner to postgres;

create table if not exists doctoral
(
	doctoral_name text not null
		constraint doctoral_pk
			primary key,
	date date,
	theme text
);

alter table doctoral owner to postgres;

create table if not exists teacher
(
	teacher_code integer not null
		constraint teacher_pk
			primary key,
	second_name text,
	first_name text,
	third_name text,
	faculty text
		constraint teacher_faculty_name_fk
			references faculty
				on update cascade on delete cascade,
	the_department text
		constraint teacher_the_department_name_fk
			references the_department
				on update cascade on delete cascade,
	teacher_category text,
	sex text,
	birthday date,
	number_of_children integer,
	salary numeric,
	doctoral text
		constraint teacher_doctoral_name_fk
			references doctoral
				on update cascade on delete cascade,
	candidate text
		constraint teacher_candidate_name_fk
			references candidate
				on update cascade on delete cascade
);

alter table teacher owner to postgres;

create table if not exists student
(
	student_code integer not null
		constraint student_pk
			primary key,
	second_name text,
	first_name text,
	third_name text,
	student_group integer
		constraint student_group_number_of_group_fk
			references groups
				on update cascade on delete cascade,
	sex text,
	birthday date,
	number_of_children integer,
	grants numeric
);

alter table student owner to postgres;

create table if not exists group_classes
(
	group_number integer not null
		constraint group_classes_group_number_of_group_fk
			references groups
				on update cascade on delete cascade,
	the_department text not null
		constraint group_classes_the_department_name_fk
			references the_department
				on update cascade on delete cascade,
	start_date date,
	finish_date date,
	teacher_code integer
		constraint group_classes_teacher_teacher_code_fk
			references teacher
				on update cascade on delete cascade,
	lesson_type text not null,
	semester integer,
	volume integer,
	lesson_name text not null,
	constraint group_classes_pk
		primary key (lesson_name, group_number, lesson_type)
);

alter table group_classes owner to postgres;

create table if not exists diploma
(
	student_code integer not null
		constraint diploma_pk
			primary key,
	diploma_name text,
	theme text,
	the_department text
		constraint diploma_the_department_name_fk
			references the_department
				on update cascade on delete cascade,
	scientific_director_code integer
		constraint diploma_teacher_teacher_code_fk
			references teacher
				on update cascade on delete cascade
);

alter table diploma owner to postgres;

create table if not exists student_record
(
	subject text not null,
	student_code integer not null
		constraint student_record_student_student_code_fk
			references student
				on update cascade on delete cascade,
	type_of_exam text,
	mark integer,
	date_of_exam date,
	teacher_code integer
		constraint student_record_teacher_teacher_code_fk
			references teacher
				on update cascade on delete cascade,
	constraint student_record_pk
		primary key (subject, student_code)
);

alter table student_record owner to postgres;

CREATE FUNCTION trigger_student_record_before() RETURNS trigger AS
'
    BEGIN
        if NEW.date_of_exam > now()
        then NEW.date_of_exam=now();
        end if;
        return NEW;
    END;'
    LANGUAGE plpgsql;

CREATE TRIGGER student_record_insert
    BEFORE INSERT OR UPDATE ON student_record FOR EACH ROW
EXECUTE PROCEDURE trigger_student_record_before();

CREATE  FUNCTION checkDate(date date) RETURNS date AS $$
BEGIN
    if date > now()
    then return null;
    else return date;
    end if;
END;
$$ LANGUAGE plpgsql;
package ua.kpi.teacherjournal

object Journal {
  type Column = String
  type Grade = Int

  sealed abstract class Record
  case class GradeRecord(grade: Grade) extends Record
  case object AbsentRecord extends Record
  case object EmptyRecord extends Record

  case class Student(name: String, records: Seq[Record], isBoss: Boolean = false)
  case class Sheet(name: String, columns: Seq[Column], students: Seq[Student]) {
    require(students.forall(_.records.size == columns.size))
  }
  case class Course(name: String, sheets: Seq[Sheet])
}

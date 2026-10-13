import scala.io.StdIn.readLine

// Function value dan lambda
val hitungNilaiStok: ((String, Int, Int, Int)) => Long =
  komoditas => komoditas._2.toLong * komoditas._3

val formatRupiah: Long => String =
  nilai => s"Rp$nilai"

// Function composition menggunakan compose
val hitungDanFormat: ((String, Int, Int, Int)) => String =
  formatRupiah.compose(hitungNilaiStok)

// Pure function dan conditional expression
def cekStatus(stok: Int, minimum: Int): String =
  if stok == 0 then "Stok Habis"
  else if stok <= minimum then "Stok Menipis"
  else "Stok Aman"

def bacaInput(): String =
  Option(readLine()).getOrElse("").trim

def bacaTeks(pesan: String): String =
  print(pesan)
  val teks = bacaInput()
  if teks.nonEmpty then teks
  else
    println("Input tidak boleh kosong.")
    bacaTeks(pesan)

def bacaAngka(pesan: String, minimum: Int): Int =
  print(pesan)
  bacaInput().toIntOption match
    case Some(angka) if angka >= minimum => angka
    case _ =>
      println(s"Harus berupa angka minimal $minimum.")
      bacaAngka(pesan, minimum)

def bacaKomoditas(urutan: Int): (String, Int, Int, Int) =
  println(s"\n--- Komoditas ke-$urutan ---")
  val nama    = bacaTeks("Nama komoditas : ")
  val harga   = bacaAngka("Harga per kg   : ", 0)
  val stok    = bacaAngka("Stok           : ", 0)
  val minimum = bacaAngka("Stok minimum   : ", 0)
  (nama, harga, stok, minimum)

def bacaSemua(
  urutan: Int,
  jumlah: Int
): List[(String, Int, Int, Int)] =
  if urutan > jumlah then Nil
  else
    val komoditas = bacaKomoditas(urutan)
    komoditas :: bacaSemua(urutan + 1, jumlah)

def lihatStok(
  daftar: List[(String, Int, Int, Int)]
): Unit =
  println("\n=== HASIL DATA STOK ===")

  daftar.foreach { data =>
    println(s"Nama       : ${data._1}")
    println(s"Stok       : ${data._3}")
    println(s"Harga/kg   : Rp${data._2}")
    println(s"Nilai stok : ${hitungDanFormat(data)}")
    println(s"Status     : ${cekStatus(data._3, data._4)}")
    println("----------------------")
  }

// Recursive method dengan base case dan recursive case
def totalStok(
  daftar: List[(String, Int, Int, Int)]
): Int =
  daftar match
    case Nil => 0
    case kepala :: ekor =>
      kepala._3 + totalStok(ekor)

@main def main(): Unit =
  val jumlah = bacaAngka("Jumlah komoditas yang diinput: ", 1)
  val daftar = bacaSemua(1, jumlah)

  lihatStok(daftar)
  println(s"Total seluruh stok: ${totalStok(daftar)}")
PROGRAM PENGELOLAAN STOK KOMODITAS

---

**DESKRIPSI**

Program ini dibuat menggunakan bahasa Scala 3 untuk mengelola data stok komoditas, seperti beras, gula, minyak goreng, dan telur. Pengguna memasukkan data melalui terminal, lalu program langsung menampilkan nilai stok dalam rupiah, status stok tiap komoditas, dan total seluruh stok.

**CARA MENJALANKAN**

Prasyarat:
- Scala 3 dan scala-cli sudah terpasang.
- Instalasi: https://scala-cli.virtuslab.org
- File program: `StokKomoditas.scala`

Langkah-langkah:
1. Buka terminal pada folder yang berisi `StokKomoditas.scala`.
2. Jalankan perintah berikut:

   ```bash
   scala-cli run StokKomoditas.scala
   ```

3. Ikuti instruksi di layar:
   - Masukkan jumlah komoditas yang ingin diinput.
   - Masukkan nama komoditas.
   - Masukkan harga per kg.
   - Masukkan jumlah stok.
   - Masukkan stok minimum.
4. Setelah semua data dimasukkan, hasil pengolahan akan langsung ditampilkan.

**CONTOH INPUT DAN OUTPUT**

Contoh input:

```text
Jumlah komoditas yang diinput: 2

--- Komoditas ke-1 ---
Nama komoditas : Beras
Harga per kg   : 10000
Stok           : 100
Stok minimum   : 50

--- Komoditas ke-2 ---
Nama komoditas : Minyak Goreng
Harga per kg   : 15000
Stok           : 15
Stok minimum   : 20
```

Contoh output:

```text
=== HASIL DATA STOK ===

Nama       : Beras
Stok       : 100
Harga/kg   : Rp10000
Nilai stok : Rp1000000
Status     : Stok Aman
----------------------

Nama       : Minyak Goreng
Stok       : 15
Harga/kg   : Rp15000
Nilai stok : Rp225000
Status     : Stok Menipis
----------------------

Total seluruh stok: 115
```

**FLOWCHART**

![Flowchart Preview](StokTani.png)

**FITUR PROGRAM**

1. **Input data dari terminal**

   Data komoditas dimasukkan langsung oleh pengguna tanpa menggunakan data bawaan.

2. **Validasi input**

   Teks kosong atau angka yang tidak valid, seperti huruf dan angka negatif, akan diminta untuk dimasukkan ulang sampai benar.

3. **Perhitungan nilai stok**

   Nilai stok dihitung menggunakan rumus:

   `Nilai stok = harga per kg × stok`

   Hasil perhitungan ditampilkan dalam format rupiah.

4. **Status stok**

   - Stok Habis: stok sama dengan 0.
   - Stok Menipis: stok kurang dari atau sama dengan stok minimum.
   - Stok Aman: stok lebih besar dari stok minimum.

5. **Total seluruh stok**

   Jumlah stok dari seluruh komoditas dihitung menggunakan metode rekursif.

**KONSEP PEMROGRAMAN FUNGSIONAL YANG DIGUNAKAN**

1. **Function Value dan Lambda**

   Fungsi `hitungNilaiStok`, `formatRupiah`, dan `hitungDanFormat` disimpan dalam `val` dan menggunakan lambda untuk menghitung nilai stok, mengubahnya menjadi format rupiah, serta menggabungkan kedua proses tersebut.

2. **Higher-Order Function**

   `foreach` digunakan untuk menerima fungsi yang memproses setiap data komoditas dalam list dan menampilkan hasilnya.

3. **Pure Function**

   Fungsi `cekStatus`, `hitungNilaiStok`, `formatRupiah`, dan `totalStok` menghasilkan output berdasarkan input tanpa mengubah data atau memiliki efek samping.

4. **Data Immutable**

   Program menggunakan `val` dan `List` untuk menyimpan data. Penambahan komoditas dilakukan menggunakan operator `::` yang menghasilkan list baru tanpa mengubah list sebelumnya.

5. **Conditional Expression**

   `if`, `else if`, dan `else` digunakan dalam fungsi `cekStatus` untuk menentukan status stok berdasarkan jumlah stok dan stok minimum.

6. **Pengolahan String, List, dan Option**

   Program menggunakan interpolasi string (`s"..."`), `trim`, `nonEmpty`, `toIntOption`, `Option`, `getOrElse`, dan `List` untuk mengolah input serta data komoditas.

7. **Function Composition**

   Fungsi `hitungDanFormat` menggabungkan `hitungNilaiStok` dan `formatRupiah` menggunakan `compose`, sehingga nilai stok dihitung terlebih dahulu sebelum diformat menjadi rupiah.

8. **Chaining**

   Contohnya adalah `Option(readLine()).getOrElse("").trim`, yang menggabungkan beberapa operasi untuk membaca input, menangani nilai kosong, dan menghapus spasi di awal maupun akhir teks.

9. **Recursive Method**

   Fungsi `bacaSemua`, `bacaTeks`, dan `bacaAngka` menggunakan rekursi untuk mengumpulkan data dan mengulangi input ketika data tidak valid. Fungsi `totalStok` menggunakan pattern matching dengan base case berupa `Nil` dan recursive case berupa penjumlahan stok elemen pertama dengan hasil pemanggilan fungsi pada sisa list.

10. **Output yang Jelas**

    Fungsi `lihatStok` menampilkan nama komoditas, jumlah stok, harga per kg, nilai stok, dan statusnya. Fungsi `totalStok` menghitung jumlah seluruh stok dan hasilnya ditampilkan pada akhir program.

**STRUKTUR FILE**

```text
miniprojek-Fungpro/
├── StokKomoditas.scala
├── StokTani.png
└── README.md
```
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class coba {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        int jum=0, i=0;
        double total_bayar=0;
        int [] kode = new int[5];
        int [] qty = new int[5];
        int [] harga = new int[5];
        double [] sub_total = new double[5];
        double [] diskon = new double [5];
        String [] barang = new String[5];

        System.out.println("Program Java Tentang Penjualan Barang");
        System.out.println("No\t Nama Barang\t\t Harga \t\t Diskon ");
        System.out.println("1\t Mouse Bluetooth\t\t Rp 149.999 \t\t 10% ");
        System.out.println("2\t Headphone Eksternal\t\t Rp 246.000 \t\t 5% ");
        System.out.println("3\t Power Bank 10.000 mAH\t\t Rp 136.000 \t\t" + " - ");
        System.out.println("4\t Tripod Kamera\t\t Rp 267.999 \t\t 20% ");
        System.out.println("5\t Smart Watch Xiaomi\t\t  Rp. 899.000 \t\t 10% ");

        System.out.print("Masukkan jumlah beli : ");
        jum = src.nextInt();
        System.out.println(" ");

        for(i = 0;i<jum;i++){
            System.out.print("Masukkan Kode Barang ke- " + (i+1)+ " : ");
            kode[i] = src.nextInt();
            System.out.print("Masukkan qty ke- " + (i+1)+ " : "); 
            qty[i] = src.nextInt();

            switch(kode[i]){
                case 1 : 
                    barang[i]= " Mouse Bluetooth 5.0 ";
                    harga[i]= 149999;
                    diskon[i]=0.1;
                    break;
                case 2 : 
                    barang[i]= " Headphone Eksternal ";
                    harga[i]= 246000;
                    diskon[i]=0.05;
                    break;
                case 3 : 
                    barang[i]= " Power Bank 10.000 mAh ";
                    harga[i]= 136000;
                    diskon[i]=0;
                    break;
                case 4 : 
                    barang[i]= " Tripod Kamera ";
                    harga[i]= 267999;
                    diskon[i]=0.2;
                    break;
                case 5 : 
                    barang[i]= " Smart Watch Xiaomi ";
                    harga[i]= 899000;
                    diskon[i]=0.1;
                    break;
                default :
                    System.out.println("Kode Barang Tidak Tersedia");
            }
        }
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        System.out.println(" ");
        System.out.println("NO \t Nama Barang \t\t Harga \t\t QTY \t Diskon \t Sub Total");
        for(i = 0;i<jum;i++){
            sub_total[i] = ((qty[i]*harga[i]) - (qty[i]*harga[i]*diskon[i]));
            total_bayar += sub_total[i];

            System.out.println((i+1) + " " + barang[i] + " " + kursIndonesia.format(harga[i]) + " " +qty[i] + " " + (int)(diskon[i]*100)+ " %" + " " +kursIndonesia.format(sub_total[i]));
            System.out.println(" ");

            System.out.println(" Total Bayar : " + kursIndonesia.format(total_bayar));
        }
    }
}


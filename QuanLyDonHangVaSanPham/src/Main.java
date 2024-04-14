import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;




//------------
 static class Product {
    int maSanPham;
    String tenSanPham;
    double giaTien;
    int soLuong;

    public Product(int maSanPham, String tenSanPham, double giaTien, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
    }


}

//------------
static class Order {
    int maDonHang;
    LocalDate ngayDatHang;
    LocalDate ngayGiaoHang;
    String tenKhachHang;
    String diaChiGiaoHang;

    public Order(int maDonHang, LocalDate ngayDatHang, LocalDate ngayGiaoHang, String tenKhachHang, String diaChiGiaoHang) {
        this.maDonHang = maDonHang;
        this.ngayDatHang = ngayDatHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
    }
}

//-----
static class OrderManagement {
    private final Scanner input;
    private final List<Order> danhSachDonHang;
    private int maDonHang;

    public OrderManagement() {
        input = new Scanner(System.in);
        danhSachDonHang = new ArrayList<>();
    }
    public void hienThiDanhSachDonHang() {
        for (Order donHang : danhSachDonHang) {
            System.out.println("--------------------------");
            System.out.println("Mã Đơn Hàng: " + donHang.maDonHang);
            System.out.println("Ngày đặt hàng: " + donHang.ngayDatHang);
            System.out.println("Ngày giao hàng: " + donHang.ngayGiaoHang);
            System.out.println("Tên khách hàng: " + donHang.tenKhachHang);
            System.out.println("Địa chỉ giao hàng: " + donHang.diaChiGiaoHang);
            System.out.println("--------------------------");
        }
    }
    public void themDonHang() {
        try {
            System.out.println("-------------------");
            System.out.println("Thêm đơn hàng mới !: ");
            System.out.println("Mã đơn hàng: ");
            int maDonHang = input.nextInt();
            input.nextLine();

            System.out.println("Ngày đặt hàng (yyyy-mm-dd): ");
            String ngayDatHangStr = input.nextLine();
            java.time.LocalDate ngayDatHang = java.time.LocalDate.parse(ngayDatHangStr);

            System.out.println("Ngày giao hàng (yyyy-mm-dd): ");
            String ngayGiaoHangStr = input.nextLine();
            java.time.LocalDate ngayGiaoHang = java.time.LocalDate.parse(ngayGiaoHangStr);

            System.out.println("Tên khách hàng: ");
            String tenKhachHang = input.nextLine();

            System.out.println("Địa chỉ giao hàng: ");
            String diaChiGiaoHang = input.nextLine();

            Order donHangMoi = new Order(maDonHang, ngayDatHang, ngayGiaoHang, tenKhachHang, diaChiGiaoHang);
            danhSachDonHang.add(donHangMoi);

            System.out.println("Đơn hàng mới đã được thêm vào thành công !");
            System.out.println("-------------------");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra, vui lòng kiểm tra lại cú pháp !");
            System.out.println("-------------------");
        }
    }

    public void suaDonHang() {
        Order donHangSua = null;
        System.out.println("--------------");
        System.out.println("Nhập mã đơn hàng cần sửa: ");
        int maDonHang = -1;
        try {
            maDonHang = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra, vui lòng nhập đúng cú pháp !");
        }
        for(Order donHang : danhSachDonHang) {
            if(donHang.maDonHang == maDonHang) {
                donHangSua = donHang;
                break;
            }
        }
        if((donHangSua != null)) {
            try {
                System.out.println("--------------");
                System.out.println("Thông tin cũ của đơn hàng:");
                System.out.println("Mã Đơn Hàng: " + donHangSua.maDonHang);
                System.out.println("Ngày đặt hàng: " + donHangSua.ngayDatHang);
                System.out.println("Ngày giao hàng: " + donHangSua.ngayGiaoHang);
                System.out.println("Tên khách hàng: " + donHangSua.tenKhachHang);
                System.out.println("Địa chỉ giao hàng: " + donHangSua.diaChiGiaoHang);
                System.out.println("-----------------");

                System.out.println("Nhập thông tin mới cho đơn hàng:");

                System.out.println("Ngày đặt hàng (yyyy-mm-dd): ");
                String ngayDatHangStr = input.nextLine();
                java.time.LocalDate ngayDatHang = java.time.LocalDate.parse(ngayDatHangStr);
                donHangSua.ngayDatHang = ngayDatHang;

                System.out.println("Ngày giao hàng (yyyy-mm-dd): ");
                String ngayGiaoHangStr = input.nextLine();
                java.time.LocalDate ngayGiaoHang = java.time.LocalDate.parse(ngayGiaoHangStr);
                donHangSua.ngayGiaoHang = ngayGiaoHang;

                System.out.println("Tên khách hàng: ");
                String tenKhachHang = input.nextLine();
                donHangSua.tenKhachHang = tenKhachHang;

                System.out.println("Địa chỉ giao hàng: ");
                String diaChiGiaoHang = input.nextLine();
                donHangSua.diaChiGiaoHang = diaChiGiaoHang;
            } catch (Exception e) {
                System.out.println("Có lỗi xảy ra, vui lòng nhập đúng cú pháp !");
            }

            System.out.println("Thông tin của đơn hàng đã được cập nhật thành công!");
            System.out.println("--------------");
        } else {
            System.out.println("Không tìm thấy đơn hàng có mã là: " + maDonHang);
            System.out.println("--------------");
        }


    }

    public void xoaDonHang() {
        Order donHangXoa = null;
        System.out.println("--------------");
        System.out.println("Nhập mã đơn hàng cần xóa: ");
        int maDonHang = -1;
        try {
            maDonHang = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra, vui lòng nhập đúng cú pháp !");
        }
        for(Order donHang : danhSachDonHang) {
            if(donHang.maDonHang == maDonHang) {
                donHangXoa = donHang;
                break;
            }
        }
        if((donHangXoa != null)) {
            danhSachDonHang.remove(donHangXoa);

            System.out.println(" Đơn hàng đã được xóa thành công!");
            System.out.println("--------------");
        } else {
            System.out.println("Không tìm thấy đơn hàng có mã là: " + maDonHang);
            System.out.println("--------------");
        }
    }
    public void xoaTatCaDonHang() {
        String xacNhan = null;
        System.out.println("--------------");
        System.out.println("Bạn có chắc muốn xóa toàn bộ đơn hàng ? Nhập \"XÓA TẤT CẢ\" để xác nhận.");
        try {
            xacNhan = input.nextLine();
        } catch (Exception e) {
            System.out.println("Xác nhận không thành công, chức năng xóa toàn bộ đơn hàng bị hủy.");
        }
        if(xacNhan.equals("XÓA TẤT CẢ")) {
            danhSachDonHang.clear();
            System.out.println("Đã xóa toàn bộ đơn hàng.");
            System.out.println("--------------");
        } else {
            System.out.println("Xác nhận không thành công, chức năng xóa toàn bộ đơn hàng bị hủy.");
            System.out.println("--------------");
        }
    }
    public void tinhGiaBan() {
        System.out.println("Nhập giá tiền sản phẩm muốn tính: ");
        double giaTien = input.nextDouble();
        System.out.println("Nhập số lượng mua: ");
        int soLuong = input.nextInt();
        double result = (giaTien*soLuong) + ((giaTien*soLuong) * 0.1);
        System.out.println("Tổng giá tiền của đơn hàng là: " + result + "USD");
    }
}
//---------
static class ProductManagement {
    private final Scanner input;
    private final List<Product> danhSachSanPham;
    private int maSanPham;

    public ProductManagement() {
        input = new Scanner(System.in);
        danhSachSanPham = new ArrayList<>();
    }
    public  void hienThiDanhSachSanPham() {
        for (Product sanPham : danhSachSanPham) {
            System.out.println("--------------------------");
            System.out.println("Mã Sản Phẩm: " + sanPham.maSanPham);
            System.out.println("Tên Sản Phẩm: " + sanPham.tenSanPham);
            System.out.println("Giá tiền Sản Phẩm: " + sanPham.giaTien);
            System.out.println("Số lượng Sản Phẩm: " + sanPham.soLuong);
            System.out.println("--------------------------");
        }
    }
    public void themSanPham() {
        try {
            System.out.println("-------------------");
            System.out.println("Thêm sản phẩm mới !: ");
            System.out.println("Mã sản phẩm: ");
            int maSanPham = input.nextInt();
            input.nextLine();
            System.out.println("Tên sản phẩm: ");
            String tenSanPham = input.nextLine();
            System.out.println("Giá tiền sản phẩm: ");
            double giaTien = input.nextDouble();
            System.out.println("Số lượng sản phẩm: ");
            int soLuong = input.nextInt();

            Product sanPhamMoi = new Product(maSanPham, tenSanPham, giaTien, soLuong);
            danhSachSanPham.add(sanPhamMoi);

            System.out.println("Sản phẩm mới đã được thêm vào thành công !");
            System.out.println("-------------------");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra, vui lòng kiểm tra lại cú pháp !");
            System.out.println("-------------------");
        }
    }

    public void suaSanPham() {
        Product sanPhamSua = null;
        System.out.println("--------------");
        System.out.println("Nhập mã sản phẩm cần sửa: ");
        int maSanPham = -1;
        try {
            maSanPham = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra, vui lòng nhập đúng cú pháp !");
        }
        for(Product sanPham : danhSachSanPham) {
            if(sanPham.maSanPham == maSanPham) {
                sanPhamSua = sanPham;
                break;
            }
        }
        if((sanPhamSua != null)) {
            try {
                System.out.println("--------------");
                System.out.println("Thông tin cũ của Sanr Phẩm:");
                System.out.println("Mã Sản Phẩm: " + sanPhamSua.maSanPham);
                System.out.println("Tên Sản Phẩm: " + sanPhamSua.tenSanPham);
                System.out.println("Giá tiền: " + sanPhamSua.giaTien);
                System.out.println("Số lượng: " + sanPhamSua.soLuong);
                System.out.println("-----------------");

                System.out.println("Nhập thông tin mới cho sản phẩm:");

                System.out.println("Tên Sản Phẩm: ");
                String tenSanPham = input.nextLine();
                sanPhamSua.tenSanPham = tenSanPham;

                System.out.println("Giá tiền: ");
                double giaTien = input.nextDouble();
                sanPhamSua.giaTien = giaTien;

                System.out.println("Số lượng: ");
                int soluong = input.nextInt();
                sanPhamSua.soLuong =soluong;

            } catch (Exception e) {
                System.out.println("Có lỗi xảy ra, vui lòng nhập đúng cú pháp !");
            }

            System.out.println("Thông tin của sản phẩm đã được cập nhật thành công!");
            System.out.println("--------------");
        } else {
            System.out.println("Không tìm thấy sản phẩm có mã là: " + maSanPham);
            System.out.println("--------------");
        }


    }

    public void xoaSanPham() {
        Product sanPhamXoa = null;
        System.out.println("--------------");
        System.out.println("Nhập mã Sản phẩm cần xóa: ");
        int maSanPham = -1;
        try {
            maSanPham = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra, vui lòng nhập đúng cú pháp !");
        }
        for(Product sanPham : danhSachSanPham) {
            if(sanPham.maSanPham == maSanPham) {
                sanPhamXoa = sanPham;
                break;
            }
        }
        if((sanPhamXoa != null)) {
            danhSachSanPham.remove(sanPhamXoa);

            System.out.println(" Sản phẩm đã được xóa thành công!");
            System.out.println("--------------");
        } else {
            System.out.println("Không tìm thấy sản phẩm có mã là: " + maSanPham);
            System.out.println("--------------");
        }
    }
    public void xoaTatCaSanPham() {
        String xacNhan = null;
        System.out.println("--------------");
        System.out.println("Bạn có chắc muốn xóa toàn bộ sản phẩm ? Nhập \"XÓA TẤT CẢ\" để xác nhận.");
        try {
            xacNhan = input.nextLine();
        } catch (Exception e) {
            System.out.println("Xác nhận không thành công, chức năng xóa toàn bộ sản phẩm bị hủy.");
        }
        if(xacNhan.equals("XÓA TẤT CẢ")) {
            danhSachSanPham.clear();
            System.out.println("Đã xóa toàn bộ sản phẩm.");
            System.out.println("--------------");
        } else {
            System.out.println("Xác nhận không thành công, chức năng xóa toàn bộ sản phẩm bị hủy.");
            System.out.println("--------------");
        }
    }
}
public class Main {
 public static void ghiDuLieu(OrderManagement donHang1, ProductManagement product1) {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("QuanLyDonHang.dat"))) {
        outputStream.writeObject(donHang1);
        outputStream.writeObject(product1);
        System.out.println("Đã ghi dữ liệu vào tệp QuanLyDonHang.dat thành công!");
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi dữ liệu vào tệp: " + e.getMessage());
    }
 }

 public static void docDuLieu() {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("QuanLyDonHang.dat"))) {
        OrderManagement donHang = (OrderManagement) inputStream.readObject();
        ProductManagement product = (ProductManagement) inputStream.readObject();
        System.out.println("Dữ liệu đơn hàng từ tệp:");
        donHang.hienThiDanhSachDonHang();
        System.out.println("Dữ liệu sản phẩm từ tệp:");
        product.hienThiDanhSachSanPham();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Lỗi khi đọc dữ liệu từ tệp: " + e.getMessage());
    }
 }


}


     public static void main(String[] args) {
         OrderManagement donHang1 = new OrderManagement();
         ProductManagement product1 = new ProductManagement();
         int choiceMuc = -1;
         int choice = -1;
         Scanner scn = new Scanner(System.in);

         try {
             while (true) {
                 System.out.println("***--- Ứng dụng quản lý đơn hàng ---***");
                 System.out.println("Lựa chọn 1 mục dưới đây để thao tác");
                 System.out.println("# Đơn Hàng - Số 1");
                 System.out.println("# Sản Phẩm - Số 2");
                 System.out.println("# Ghi dữ liệu - Số 3");
                 System.out.println("# Đọc dữ liệu - Số 4");
                 choiceMuc = scn.nextInt();
                 if (choiceMuc == 1) {
                     System.out.println("---------------------");
                     System.out.println("Đã lựa chọn: Thao tác với đơn hàng.");

                     System.out.println("Mời bạn lựa chọn 1 chức năng dưới đây để thao tác: ");
                     System.out.println("+ Hiển thị danh sách đơn hàng - Số 1");
                     System.out.println("+ Thêm đơn hàng - Số 2 ");
                     System.out.println("+ Sửa đơn hàng - Số 3 ");
                     System.out.println("+ Xóa một đơn hàng cụ thể - Số 4");
                     System.out.println("+ Xóa tất cả đơn hàng - Số 5");
                     System.out.println("+ Tính giá bán tới người dùng - Số 6");

                     System.out.println("-------------------");

                     System.out.println("Nhập lựa chọn của bạn, tương ứng với số: ");
                     choice = scn.nextInt();
                     if (choice == 1) {
                         donHang1.hienThiDanhSachDonHang();
                     } else if (choice == 2) {
                         donHang1.themDonHang();
                     } else if (choice == 3) {
                         donHang1.suaDonHang();
                     } else if (choice == 4) {
                         donHang1.xoaDonHang();
                     } else if (choice == 5) {
                         donHang1.xoaTatCaDonHang();
                     } else if (choice == 6) {
                         donHang1.tinhGiaBan();
                     } else {
                         System.out.println("Vui lòng chọn đúng lựa chọn !");
                         System.out.println("-------------------");
                     }
                 } else if (choiceMuc == 2) {
                     System.out.println("---------------------");
                     System.out.println("Đã lựa chọn: Thao tác với Sản Phẩm");
                     System.out.println("Mời bạn lựa chọn 1 chức năng dưới đây để thao tác: ");
                     System.out.println("+ Hiển thị danh sách Sản Phẩm - Số 1");
                     System.out.println("+ Thêm Sản Phẩm - Số 2 ");
                     System.out.println("+ Sửa Sản Phẩm - Số 3 ");
                     System.out.println("+ Xóa một Sản Phẩm cụ thể - Số 4");
                     System.out.println("+ Xóa tất cả Sản Phẩm - Số 5");
                     System.out.println("+ Hiển thị giá bán của sản phẩm - Số 6");

                     System.out.println("-------------------");

                     System.out.println("Nhập lựa chọn của bạn, tương ứng với số: ");
                     choice = scn.nextInt();
                     if (choice == 1) {
                         product1.hienThiDanhSachSanPham();
                     } else if (choice == 2) {
                         product1.themSanPham();
                     } else if (choice == 3) {
                         product1.suaSanPham();
                     } else if (choice == 4) {
                         product1.xoaSanPham();
                     } else if (choice == 5) {
                         product1.xoaTatCaSanPham();
                     } else {
                         System.out.println("Vui lòng chọn đúng lựa chọn !");
                         System.out.println("-------------------");
                     }
                 } else if (choiceMuc == 3) {
                     Main.ghiDuLieu(donHang1, product1);
                     System.out.println("Lưu dữ liệu thành công!");
                 } else if (choiceMuc == 4) {
                     Main.docDuLieu();
                     System.out.println("Đọc dữ liệu thành công!");
                 } else {
                     System.out.println("Vui lòng chọn đúng lựa chọn !");
                 }
             }
         } catch (Exception e) {
             System.out.println("Vui lòng chọn đúng lựa chọn ! Khởi động lại chương trình");

         }
     }










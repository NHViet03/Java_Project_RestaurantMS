DROP table NguoiDung
--Tao bang NguoiDung
create table NguoiDung(
    ID_ND NUMBER(8,0) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    Email varchar2(50),
    Matkhau varchar2(20),
    VerifyCode varchar2(10)DEFAULT NULL,
    Trangthai varchar2(10) DEFAULT '',
    Vaitro varchar2(20)
)
---Them rang buoc
alter table NguoiDung
    add constraint ND_Email_NNULL check ('Email' is not null)
    add constraint ND_Matkhau_NNULL check ('Matkhau' is not null)
    add constraint ND_Vaitro_Ten check (Vaitro in ('Khach Hang','Nhan Vien','Nhan Vien Kho','Quan Ly'));

---Them khoa chinh
alter table NguoiDung
    add constraint NguoiDung_PK PRIMARY KEY (ID_ND);
    
insert into NguoiDung(email,matkhau,vaitro) values ('11','22','Khach Hang');    
--Tao bang KhachHang
drop table KhachHang;
ALTER SESSION SET NLS_DATE_FORMAT = 'dd-MM-YYYY';
create table KhachHang(
    ID_KH NUMBER(8,0) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    TenKH varchar2(50), 
    Ngaythamgia date, 
    Doanhso number(10,0), 
    Diemtichluy number(5,0),
    ID_ND NUMBER(8,0)
)
--Them Check Constraint
alter table KhachHang
    add constraint KH_TenKH_NNULL check ('TenKH' is not null)
    add constraint KH_Ngaythamgia_NNULL check ('Ngaythamgia' is not null)
    add constraint KH_Doanhthu_NNULL check ('Doanhthu' is not null)
    add constraint KH_Diemtichluy_NNULL check ('Diemtichluy' is not null)
    add constraint KH_IDND_NNULL check ('ID_ND' is not null);

---Them khoa chinh
alter table KhachHang
    add constraint KhachHang_PK PRIMARY KEY (ID_KH);
    
---Them khoa ngoai
ALTER TABLE KhachHang
 ADD CONSTRAINT KH_fk_idND FOREIGN KEY 
 (ID_ND) REFERENCES NguoiDung(ID_ND);

--
drop table MonAn;
--Tao bang MonAn
create table MonAn(
    ID_MonAn NUMBER(8,0) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    TenMon varchar2(50), 
    DonGia number(8,0),
    Loai varchar2(50)
)
--Them Check Constraint
alter table MonAn
    add constraint MA_TenMon_NNULL check ('TenMon' is not null)
    add constraint MA_DonGia_NNULL check ('Dongia' is not null)
    add constraint MA_Loai_Ten check (Loai in ('Aries','Taurus','Gemini','Cancer','Leo','Virgo'
                                                 ,'Libra','Scorpio','Sagittarius','Capricorn','Aquarius','Pisces'));

--Them khoa chinh
alter table MonAn
    add constraint MonAn_PK PRIMARY KEY (ID_MonAn);


--Them data
--Aries
insert into MonAn(TenMon,Dongia,Loai) values('DUI CUU NUONG XE NHO', 250000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('BE SUON CUU NUONG GIAY BAC MONG CO', 230000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('DUI CUU NUONG TRUNG DONG', 350000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('CUU XOC LA CA RI', 129000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('CUU KUNGBAO', 250000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('BAP CUU NUONG CAY', 250000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('CUU VIEN HAM CAY', 19000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('SUON CONG NUONG MONG CO', 250000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('DUI CUU LON NUONG TAI BAN', 750000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('SUONG CUU NUONG SOT NAM', 450000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('DUI CUU NUONG TIEU XANH', 285000,'Aries');
insert into MonAn(TenMon,Dongia,Loai) values('SUON CUU SOT PHO MAI', 450000,'Aries');

--Taurus
insert into MonAn(TenMon,Dongia,Loai) values('Bit tet bo My khoai tay', 179000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Bo bit tet Uc',169000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Bit tet bo My BASIC', 179000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('My Y bo bam', 169000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Thit suon Wagyu', 1180000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Steak Thit Vai Wagyu', 1290000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Steak Thit Bung Bo', 550000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Tomahawk', 2390000,'Taurus');
insert into MonAn(TenMon,Dongia,Loai) values('Salad Romaine Nuong', 180000,'Taurus');

--Gemini
insert into MonAn(TenMon,Dongia,Loai) values('Combo Happy', 180000,'Gemini');
insert into MonAn(TenMon,Dongia,Loai) values('Combo Fantastic', 190000,'Gemini');
insert into MonAn(TenMon,Dongia,Loai) values('Combo Dreamer', 230000,'Gemini');
insert into MonAn(TenMon,Dongia,Loai) values('Combo Cupid', 180000,'Gemini');
insert into MonAn(TenMon,Dongia,Loai) values('Combo Poseidon', 190000,'Gemini');
insert into MonAn(TenMon,Dongia,Loai) values('Combo LUANG PRABANG', 490000,'Gemini');
insert into MonAn(TenMon,Dongia,Loai) values('Combo VIENTIANE', 620000,'Gemini');

--Cancer
insert into MonAn(TenMon,Dongia,Loai) values('Cua KingCrab Duc sot', 3650000,'Cancer');
insert into MonAn(TenMon,Dongia,Loai) values('Mai Cua KingCrab Topping Pho Mai', 2650000,'Cancer');
insert into MonAn(TenMon,Dongia,Loai) values('Cua KingCrab sot Tu Xuyen', 2300000,'Cancer');
insert into MonAn(TenMon,Dongia,Loai) values('Cua KingCrab Nuong Tu Nhien', 2550000,'Cancer');
insert into MonAn(TenMon,Dongia,Loai) values('Cua KingCrab Nuong Bo Toi', 2650000,'Cancer');
insert into MonAn(TenMon,Dongia,Loai) values('Com Mai Cua KingCrab Chien', 1850000,'Cancer');

--Leo
insert into MonAn(TenMon,Dongia,Loai) values('BOSSAM', 650000,'Leo');
insert into MonAn(TenMon,Dongia,Loai) values('KIMCHI PANCAKE', 350000,'Leo');
insert into MonAn(TenMon,Dongia,Loai) values('SPICY RICE CAKE', 250000,'Leo');
insert into MonAn(TenMon,Dongia,Loai) values('SPICY SAUSAGE HOTPOT', 650000,'Leo');
insert into MonAn(TenMon,Dongia,Loai) values('SPICY PORK', 350000,'Leo');
insert into MonAn(TenMon,Dongia,Loai) values('MUSHROOM SPICY SILKY TOFU STEW', 350000,'Leo');
--Virgo
insert into MonAn(TenMon,Dongia,Loai) values('Pavlova', 150000,'Virgo');
insert into MonAn(TenMon,Dongia,Loai) values('Kesutera', 120000,'Virgo');
insert into MonAn(TenMon,Dongia,Loai) values('Cremeschnitte', 250000,'Virgo');
insert into MonAn(TenMon,Dongia,Loai) values('Sachertorte', 150000,'Virgo');
insert into MonAn(TenMon,Dongia,Loai) values('Schwarzwalder Kirschtorte', 250000,'Virgo');
insert into MonAn(TenMon,Dongia,Loai) values('New York-Style Cheesecake', 250000,'Virgo');

--Libra
insert into MonAn(TenMon,Dongia,Loai) values('Cobb Salad', 150000,'Libra');
insert into MonAn(TenMon,Dongia,Loai) values('Salad Israeli', 120000,'Libra');
insert into MonAn(TenMon,Dongia,Loai) values('Salad Dau den', 120000,'Libra');
insert into MonAn(TenMon,Dongia,Loai) values('Waldorf Salad', 160000,'Libra');
insert into MonAn(TenMon,Dongia,Loai) values('Salad Gado-Gado', 200000,'Libra');
insert into MonAn(TenMon,Dongia,Loai) values('Nicoise Salad', 250000,'Libra');

--Scorpio
insert into MonAn(TenMon,Dongia,Loai) values('BULGOGI LUNCHBOX', 250000,'Scorpio');
insert into MonAn(TenMon,Dongia,Loai) values('CHICKEN TERIYAKI LUNCHBOX', 350000,'Scorpio');
insert into MonAn(TenMon,Dongia,Loai) values('SPICY PORK LUNCHBOX', 350000,'Scorpio');
insert into MonAn(TenMon,Dongia,Loai) values('TOFU TERIYAKI LUNCHBOX', 250000,'Scorpio');

--Sagittarius
insert into MonAn(TenMon,Dongia,Loai) values('Thit ngua do tuoi', 250000,'Sagittarius');
insert into MonAn(TenMon,Dongia,Loai) values('Steak Thit ngua', 350000,'Sagittarius');
insert into MonAn(TenMon,Dongia,Loai) values('Thit ngua ban gang', 350000,'Sagittarius');
insert into MonAn(TenMon,Dongia,Loai) values('Long ngua xao dua', 150000,'Sagittarius');
insert into MonAn(TenMon,Dongia,Loai) values('Thit ngua xao sa ot', 250000,'Sagittarius');
insert into MonAn(TenMon,Dongia,Loai) values('Ngua tang', 350000,'Sagittarius');

--Capricorn
insert into MonAn(TenMon,Dongia,Loai) values('Thit de xong hoi', 229000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Thit de xao rau ngo', 199000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Thit de nuong tang', 229000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Thit de chao', 199000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Thit de nuong xien', 199000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Nam de nuong/chao', 199000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Thit de xao lan', 19000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Dui de tan thuoc bac', 199000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Canh de ham duong quy', 199000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Chao de dau xanh', 50000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Thit de nhung me', 229000,'Capricorn');
insert into MonAn(TenMon,Dongia,Loai) values('Lau de nhu', 499000,'Capricorn');


--Aquarius
insert into MonAn(TenMon,Dongia,Loai) values('SIGNATURE WINE', 3290000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('CHILEAN WINE', 3990000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('ARGENTINA WINE', 2890000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('ITALIAN WINE', 5590000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('AMERICAN WINE', 4990000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('CLASSIC COCKTAIL', 200000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('SIGNATURE COCKTAIL', 250000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('MOCKTAIL', 160000,'Aquarius');
insert into MonAn(TenMon,Dongia,Loai) values('JAPANESE SAKE', 1490000,'Aquarius');

--Pisces
insert into MonAn(TenMon,Dongia,Loai) values('Ca Hoi Ngam Tuong', 289000,'Pisces');
insert into MonAn(TenMon,Dongia,Loai) values('Ca Ngu Ngam Tuong', 289000,'Pisces');
insert into MonAn(TenMon,Dongia,Loai) values('IKURA:Trung ca hoi', 189000,'Pisces');
insert into MonAn(TenMon,Dongia,Loai) values('KARIN:Sashimi Ca Ngu', 149000,'Pisces');
insert into MonAn(TenMon,Dongia,Loai) values('KEIKO:Sashimi Ca Hoi', 199000,'Pisces');
insert into MonAn(TenMon,Dongia,Loai) values('CHIYO:Sashimi Bung Ca Hoi', 219000,'Pisces');

SELECT * FROM MonAn WHERE UPPER(TenMon) like '%E%'
Order by tenmon asc;


--Tao bang Ban
drop table Ban;
create table Ban(
    ID_Ban NUMBER(8,0) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    TenBan varchar2(50), 
    Vitri varchar2(50), 
    Trangthai varchar2(50)
)
--Them Check Constraint
alter table Ban
    add constraint Ban_TenBan_NNULL check ('TenBan' is not null)
    add constraint Ban_Vitri_NNULL check ('Vitri' is not null)
    add constraint Ban_Trangthai_Ten check (Trangthai in ('Con trong','Dang dung bua','Da dat truoc'));

--Them khoa chinh
alter table Ban
    add constraint Ban_PK PRIMARY KEY (ID_Ban);


--Them data cho Ban
--Tang 1
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.1','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.2','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.3','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.4','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.5','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.6','Tang 1','Da dat truoc');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.7','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.8','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.9','Tang 1','Da dat truoc');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.10','Tang 1','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.11','Tang 1','Da dat truoc');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T1.12','Tang 1','Dang dung bua');
--Tang 2
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.1','Tang 2','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.2','Tang 2','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.3','Tang 2','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.4','Tang 2','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.5','Tang 2','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.6','Tang 2','Da dat truoc');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.7','Tang 2','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.8','Tang 2','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.9','Tang 2','Da dat truoc');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.10','Tang 2','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.11','Tang 2','Da dat truoc');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T2.12','Tang 2','Dang dung bua');
--Tang 3
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Dang dung bua');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');
insert into Ban(TenBan,Vitri,Trangthai) values('Ban T3.1','Tang 3','Con trong');


--Tao bang Voucher

--Tao bang Voucher
drop table Voucher;

create table Voucher(
    Code_Voucher varchar2(10),
    Mota varchar2(50),
    Phantram number(3,0),
    LoaiMA varchar2(50),
    SoLuong number(3,0),
    Diem number(8,0)
)
--Them Check Constraint
alter table Voucher
    add constraint V_Code_NNULL check ('Code_Voucher' is not null)
    add constraint V_Mota_NNULL check ('Mota' is not null)
    add constraint V_Phantram_NNULL check (Phantram > 0 AND Phantram <= 100)
    add constraint V_LoaiMA_Thuoc check (LoaiMA in ('All','Aries','Taurus','Gemini','Cancer','Leo','Virgo'
                                                 ,'Libra','Scorpio','Sagittarius','Capricorn','Aquarius','Pisces'));

---Them khoa chinh
alter table Voucher
    add constraint Voucher_PK PRIMARY KEY (Code_Voucher);
    
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('loQy','20% off for Aries Menu',20,'Aries',10,200);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('pCfI','30% off for Taurus Menu',30,'Taurus',5,300);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('pApo','20% off for Gemini Menu',20,'Gemini',10,200);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('ugQx','100% off for Virgo Menu',100,'Virgo',3,500);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('nxVX','20% off for All Menu',20,'All',5,300);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('Pwyn','20% off for Cancer Menu',20,'Cancer',10,200);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('bjff','50% off for Leo Menu',50,'Leo',5,600);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('YPzJ','20% off for Aquarius Menu',20,'Aquarius',5,200);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('Y5g0','30% off for Pisces Menu',30,'Pisces',5,300);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('7hVO','60% off for Aries Menu',60,'Aries',0,1000);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('WHLm','20% off for Capricorn Menu',20,'Capricorn',0,200);
insert into Voucher(Code_Voucher, Phantram,LoaiMA,SoLuong,Diem) values ('GTsC','20% off for Leo Menu',20,'Leo',0,200);


--Tao bang HoaDon
drop table HoaDon;

create table HoaDon(
    ID_HoaDon NUMBER(8,0) GENERATED ALWAYS as IDENTITY(START with 100 INCREMENT by 1),
    ID_KH number(8,0),
    ID_Ban number(8,0),
    NgayHD date,
    TienMonAn number(8,0),
    Code_Voucher varchar2(10),
    TienGiam number(8,0),
    Tongtien number(10,0),
    Trangthai varchar2(50)
)

--Them Check Constraint
alter table HoaDon
    add constraint HD_NgayHD_NNULL check ('TenMon' is not null)
    add constraint HD_TrangThai check (Trangthai in ('Chua thanh toan','Da thanh toan'));

--Them khoa chinh
alter table HoaDon
    add constraint HD_PK PRIMARY KEY (ID_HoaDon);

ALTER TABLE HoaDon
 ADD CONSTRAINT HD_fk_idKH FOREIGN KEY 
 (ID_KH) REFERENCES KhachHang(ID_KH)
 ADD CONSTRAINT HD_fk_idBan FOREIGN KEY 
 (ID_Ban) REFERENCES Ban(ID_Ban);
 
 
 
SELECT Ban.ID_Ban,TenBan FROM HoaDon JOIN Ban ON HoaDon.ID_Ban=Ban.ID_Ban WHERE ID_KH=42;
 
--Tao bang CTHD
drop table CTHD;
create table CTHD(
    ID_HoaDon NUMBER(8,0),
    ID_MonAn number(8,0),
    SoLuong number(3,0),
    Thanhtien number(10,0)
)

--Them Check Constraint
alter table CTHD
    add constraint CTHD_SoLuong_NNULL check ('SoLuong' is not null);

--Them khoa chinh
alter table CTHD
    add constraint CTHD_PK PRIMARY KEY (ID_HoaDon,ID_MonAn);

ALTER TABLE CTHD
 ADD CONSTRAINT CTHD_fk_idHD FOREIGN KEY 
 (ID_HoaDon) REFERENCES HoaDon(ID_HoaDon)
 ADD CONSTRAINT CTHD_fk_idMonAn FOREIGN KEY 
 (ID_MonAn) REFERENCES MonAn(ID_MonAn);
 









--- Tao Trigger

-- Thanh tien o CTHD bang SoLuong x Dongia cua mon an do
CREATE OR REPLACE TRIGGER CTHD_Thanhtien
BEFORE INSERT OR UPDATE ON CTHD
FOR EACH ROW
DECLARE 
    gia MonAn.Dongia%TYPE;
BEGIN
    SELECT DonGia
    INTO gia
    FROM MonAn
    Where MonAn.ID_MonAn=:new.ID_MonAn;
    
    :new.Thanhtien := :new.SoLuong * gia;
END;
--- Tien mon an o Hoa Don bang tong thanh tien o CTHD
CREATE OR REPLACE TRIGGER HD_TienMonAn
AFTER INSERT OR UPDATE ON CTHD
FOR EACH ROW
BEGIN
    UPDATE HoaDon SET TienMonAn = TienMonAn + :new.ThanhTien WHERE HoaDon.ID_HoaDon=:new.ID_HoaDon;
END;

-- Tong tien o Hoa Don = Tien mon an - Tien giam
CREATE OR REPLACE TRIGGER HD_Tongtien
BEFORE INSERT OR UPDATE ON HoaDon
FOR EACH ROW
BEGIN
    :new.Tongtien := :new.TienMonAn-:new.TienGiam;
END;
 
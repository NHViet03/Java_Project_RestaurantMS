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
    add constraint MA_Doanhthu_NNULL check ('Mota' is not null)
    add constraint MA_Diemtichluy_NNULL check ('Diemtichluy' is not null)
    add constraint MA_IDND_NNULL check ('ID_ND' is not null);

---Them khoa chinh
alter table KhachHang
    add constraint KhachHang_PK PRIMARY KEY (ID_KH);
    
---Them khoa ngoai
ALTER TABLE KhachHang
 ADD CONSTRAINT KH_fk_idND FOREIGN KEY 
 (ID_ND) REFERENCES NguoiDung(ID_ND);

--
drop table MonAn
--Tao bang MonAn
create table MonAn(
    ID_MonAn NUMBER(8,0) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    TenMon varchar2(50), 
    NguonGoc varchar2(50), 
    Mota varchar2(50), 
    DonGia number(8,0),
    Loai varchar2(50)
)
--Them Check Constraint
alter table MonAn
    add constraint MA_TenMon_NNULL check ('TenMon' is not null)
    add constraint MA_NguocGoc_NNULL check ('NguocGoc' is not null)
    add constraint MA_Mota_NNULL check ('Mota' is not null)
    add constraint MA_DonGia_NNULL check ('Dongia' is not null)
    add constraint MA_Loai_Ten check (Loai in ('Aries','Taurus','Gemini','Cancer','Leo','Virgo'
                                                 ,'Libra','Scorpio','Sagittarius','Capricorn','Aquarius','Pisces'));

--Them khoa chinh
alter table MonAn
    add constraint MonAn_PK PRIMARY KEY (ID_MonAn);


--Them data
--Aries
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('DUI CUU NUONG XE NHO','Viet Nam',' ',250000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('BE SUON CUU NUONG GIAY BAC MONG CO','Viet Nam',' ',230000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('DUI CUU NUONG TRUNG DONG','Viet Nam',' ',350000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CUU XOC LA CA RI','Viet Nam',' ',129000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CUU KUNGBAO','Viet Nam',' ',250000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('BAP CUU NUONG T CAY','Viet Nam',' ',250000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CUU VIEN HAM T CAY','Viet Nam',' ',19000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SUON CONG NUONG MONG CO','Viet Nam',' ',250000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('DUI CUU LON NUONG TAI BAN','Viet Nam',' ',750000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SUONG CUU NUONG T NAM','Viet Nam',' ',450000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('DUI CUU NUONG T TIEU XANH','Viet Nam',' ',285000,'Aries');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SUON CUU T PHO MAI','Viet Nam',' ',450000,'Aries');

--Taurus
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Bit tet bo My khoai tay','My',' ',179000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Bo bit tet Uc','Uc',' ',169000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Bit tet bo My BASIC','My',' ',179000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('My Y bo bam','Y',' ',169000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit suon Wagyu','Nhat Ban',' ',1180000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Steak Thit Vai Wagyu','Nhat Ban',' ',1290000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Steak Thit Bung Bo','Nhat Ban',' ',550000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Tomahawk','Nhat Ban',' ',2390000,'Taurus');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Salad Romaine Nuong','Nhat Ban',' ',180000,'Taurus');

--Gemini
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo Happy','Viet Nam',' ',180000,'Gemini');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo Fantastic','Viet Nam',' ',190000,'Gemini');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo Dreamer','Viet Nam',' ',230000,'Gemini');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo Cupid','Viet Nam',' ',180000,'Gemini');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo Poseidon','Viet Nam',' ',190000,'Gemini');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo LUANG PRABANG','Viet Nam',' ',490000,'Gemini');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Combo VIENTIANE','Viet Nam',' ',620000,'Gemini');

--Cancer
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Cua KingCrab Duc t','Viet Nam',' ',3650000,'Cancer');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Mai Cua KingCrab Topping Pho Mai','Viet Nam',' ',2650000,'Cancer');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Cua KingCrab t Tu Xuyen','Viet Nam',' ',2300000,'Cancer');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Cua KingCrab Nuong Tu Nhien','Viet Nam',' ',2550000,'Cancer');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Cua KingCrab Nuong Bo Toi','Viet Nam',' ',2650000,'Cancer');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Com Mai Cua KingCrab Chien','Viet Nam',' ',1850000,'Cancer');

--Leo
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('BOSSAM','Han Quoc',' ',650000,'Leo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('KIMCHI PANCAKE','Han Quoc',' ',350000,'Leo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SPICY RICE CAKE','Han Quoc',' ',250000,'Leo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SPICY SAUSAGE HOTPOT','Han Quoc',' ',650000,'Leo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SPICY PORK','Han Quoc',' ',350000,'Leo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('MUSHROOM SPICY SILKY TOFU STEW','Han Quoc',' ',350000,'Leo');
--Virgo
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Pavlova','New Zealand',' ',150000,'Virgo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Kesutera','Nhat Ban',' ',120000,'Virgo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Cremeschnitte','New Zealand',' ',250000,'Virgo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Sachertorte','New Zealand',' ',150000,'Virgo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Schwarzwalder Kirschtorte','New Zealand',' ',250000,'Virgo');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('New York-Style Cheesecake','My',' ',250000,'Virgo');

--Libra
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Cobb Salad','Viet Nam',' ',150000,'Libra');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Salad Israeli','Viet Nam',' ',120000,'Libra');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Salad Dau den','Viet Nam',' ',120000,'Libra');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Waldorf Salad','Viet Nam',' ',160000,'Libra');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Salad Gado-Gado','Viet Nam',' ',200000,'Libra');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Nicoise Salad','Viet Nam',' ',250000,'Libra');

--Scorpio
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('BULGOGI LUNCHBOX','Han Quoc',' ',250000,'Scorpio');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CHICKEN TERIYAKI LUNCHBOX','Han Quoc',' ',350000,'Scorpio');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SPICY PORK LUNCHBOX','Han Quoc',' ',350000,'Scorpio');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('TOFU TERIYAKI LUNCHBOX','Han Quoc',' ',250000,'Scorpio');

--Sagittarius
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit ngua do tuoi','Viet Nam',' ',250000,'Sagittarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Steak Thit ngua','Viet Nam',' ',350000,'Sagittarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit ngua ban gang','Viet Nam',' ',350000,'Sagittarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Long ngua xao dua','Viet Nam',' ',150000,'Sagittarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit ngua xao sa ot','Viet Nam',' ',250000,'Sagittarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Ngua tang','Viet Nam',' ',350000,'Sagittarius');

--Capricorn
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de xong hoi','Viet Nam',' ',229000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de xao rau ngo','Viet Nam',' ',199000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de nuong tang','Viet Nam',' ',229000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de chao','Viet Nam',' ',199000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de nuong xien','Viet Nam',' ',199000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Nam de nuong/chao','Viet Nam',' ',199000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de xao lan','Viet Nam',' ',19000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Dui de tan thuoc bac','Viet Nam',' ',199000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Canh de ham duong quy','Viet Nam',' ',199000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Chao de dau xanh','Viet Nam',' ',50000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Thit de nhung me','Viet Nam',' ',229000,'Capricorn');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Lau de nhu','Viet Nam',' ',499000,'Capricorn');


--Aquarius
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SIGNATURE WINE','Phap',' ',3290000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CHILEAN WINE','Phap',' ',3990000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('ARGENTINA WINE','Argentina',' ',2890000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('ITALIAN WINE','Italia',' ',5590000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('AMERICAN WINE','My',' ',4990000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CLASSIC COCKTAIL','Singapore',' ',200000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('SIGNATURE COCKTAIL','Singapore',' ',250000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('MOCKTAIL','Nhat Ban',' ',160000,'Aquarius');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('JAPANESE SAKE','Nhat Ban',' ',1490000,'Aquarius');

--Pisces
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Ca Hoi Ngam Tuong','Nhat Ban',' ',289000,'Pisces');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('Ca Ngu Ngam Tuong','Nhat Ban',' ',289000,'Pisces');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('IKURA :Trung ca hoi','Nhat Ban',' ',189000,'Pisces');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('KARIN:Sashimi Ca Ngu','Nhat Ban',' ',149000,'Pisces');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('KEIKO:Sashimi Ca Hoi','Nhat Ban',' ',199000,'Pisces');
insert into MonAn(TenMon,NguonGoc,Mota,Dongia,Loai) values('CHIYO:Sashimi Bung Ca Hoi','Nhat Ban',' ',219000,'Pisces');

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
    
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('loQy','20% off for Aries Menu',20,'Aries',10,200);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('pCfI','30% off for Taurus Menu',30,'Taurus',5,300);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('pApo','20% off for Gemini Menu',20,'Gemini',10,200);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('ugQx','100% off for Virgo Menu',100,'Virgo',3,500);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('nxVX','20% off for All Menu',20,'All',5,300);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('Pwyn','20% off for Cancer Menu',20,'Cancer',10,200);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('bjff','50% off for Leo Menu',50,'Leo',5,600);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('YPzJ','20% off for Aquarius Menu',20,'Aquarius',5,200);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('Y5g0','30% off for Pisces Menu',30,'Pisces',5,300);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('7hVO','60% off for Aries Menu',60,'Aries',0,1000);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('WHLm','20% off for Capricorn Menu',20,'Capricorn',0,200);
insert into Voucher(Code_Voucher,Mota,Phantram,LoaiMA,SoLuong,Diem) values ('GTsC','20% off for Leo Menu',20,'Leo',0,200);

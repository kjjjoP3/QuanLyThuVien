/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thanh
 */
public class SachTest {

    public SachTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMaSach method, of class Sach.
     */
    @Test
    public void testGetMaSach() {
        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getMaSach();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaSach method, of class Sach.
     */
    @Test
    public void testSetMaSach() {
        System.out.println("Chay ma sach M01");
        String maSach = "M01";
        Sach instance = new Sach();
        instance.setMaSach(maSach);
        String expected = "M01";
        assertEquals(expected, instance.getMaSach());
    }

    /**
     * Test of getTenSach method, of class Sach.
     */
    @Test
    public void testGetTenSach() {
        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getTenSach();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTenSach method, of class Sach.
     */
    @Test
    public void testSetTenSach() {
        System.out.println("Chay Set Ten Ma HoatHinh");
        String tenSach = "HoatHinh";
        Sach instance = new Sach();
        instance.setTenSach(tenSach);
        String expected = "HoatHinh";
        assertEquals(expected, instance.getTenSach());
    }

    /**
     * Test of getMaTheLoai method, of class Sach.
     */
    @Test
    public void testGetMaTheLoai() {

        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getMaTheLoai();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMaTheLoai method, of class Sach.
     */
    @Test
    public void testSetMaTheLoai() {

        String maTheLoai = "KinhDi";
        Sach instance = new Sach();
        instance.setMaTheLoai(maTheLoai);
        String expected = "KinhDi";
        assertEquals(expected, instance.getMaTheLoai());
    }

    /**
     * Test of getTacGia method, of class Sach.
     */
    @Test
    public void testGetTacGia() {

        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getTacGia();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTacGia method, of class Sach.
     */
    @Test
    public void testSetTacGia() {
        System.out.println("Chay Ten Tac Gia LENAM");
        String tacGia = "";
        Sach instance = new Sach();
        instance.setTacGia(tacGia);
        String expected = "KinhDi";
        assertEquals(expected, instance.getTacGia());
    }

    /**
     * Test of getSoLuong method, of class Sach.
     */
    @Test
    public void testGetSoLuong() {
        Sach instance = new Sach();
        int expResult = 0;
        int result = instance.getSoLuong();
        assertEquals(expResult, result);

    }

    /**
     * Test of setSoLuong method, of class Sach.
     */
    @Test
    public void testSetSoLuong() {
        System.out.println("Truyen vao so luong 600");
        int soLuong = 600;
        Sach instance = new Sach();
        instance.setSoLuong(soLuong);
        int expected = 600;
        int result = instance.getSoLuong();

        assertEquals(expected, result);
    }

    @Test
    public void testSetSoLuongWithNegative() {
        System.out.println("Truyen vao so luong gia tri am");
        int soLuong = -600;
        Sach instance = new Sach();
        instance.setSoLuong(soLuong);

        Exception exception = assertThrows(Exception.class,
                ()-> instance.setSoLuong(soLuong));

        int expected = 600;
        int result = instance.getSoLuong();

        assertEquals(expected, result);
    }
    
    
    @Test
    public void testSetSoLuongWithLarge() {
        System.out.println("Truyen vao so luong gia tri duong ++");
        int soLuong = 600000000;
        Sach instance = new Sach();
        instance.setSoLuong(soLuong);

        Exception exception = assertThrows(Exception.class,
                ()-> instance.setSoLuong(soLuong));

        int expected = 600;
        int result = instance.getSoLuong();

        assertEquals(expected, result);
    }

    /**
     * Test of getNxb method, of class Sach.
     */
    @Test
    public void testGetNxb() {
        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getNxb();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNxb method, of class Sach.
     */
    @Test
    public void testSetNxb() {
        System.out.println("Chay Ten NXB: NguyenKim");
        String nxb = "NguyenKim";
        Sach instance = new Sach();
        instance.setNxb(nxb);
        String expected = "NguyenKim";
        assertEquals(expected, instance.getNxb());
       
    }

    /**
     * Test of getNgayNhap method, of class Sach.
     */
    @Test
    public void testGetNgayNhap() {
        System.out.println("getNgayNhap");
        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getNgayNhap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNgayNhap method, of class Sach.
     */
    @Test
    public void testSetNgayNhap() {
        System.out.println("setNgayNhap");
        String ngayNhap = "";
        Sach instance = new Sach();
        instance.setNgayNhap(ngayNhap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNdtt method, of class Sach.
     */
    @Test
    public void testGetNdtt() {
        System.out.println("getNdtt");
        Sach instance = new Sach();
        String expResult = "";
        String result = instance.getNdtt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNdtt method, of class Sach.
     */
    @Test
    public void testSetNdtt() {
        System.out.println("setNdtt");
        String ndtt = "";
        Sach instance = new Sach();
        instance.setNdtt(ndtt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHinh method, of class Sach.
     */
    @Test
    public void testGetHinh() {
        System.out.println("getHinh");
        Sach instance = new Sach();
        byte[] expResult = null;
        byte[] result = instance.getHinh();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHinh method, of class Sach.
     */
    @Test
    public void testSetHinh() {
        System.out.println("setHinh");
        byte[] Hinh = null;
        Sach instance = new Sach();
        instance.setHinh(Hinh);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sach.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sach instance = new Sach();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

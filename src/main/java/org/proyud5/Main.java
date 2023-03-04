package org.proyud5;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import org.proyud5.database.MongoDbConnection;
import org.proyud5.database.MongoDbCollectionPersistenceManager;
import org.proyud5.model.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static MongoDbCollectionPersistenceManager clientesCollectionManager = new MongoDbCollectionPersistenceManager("clientes");
    static MongoDbCollectionPersistenceManager productosCollectionManager = new MongoDbCollectionPersistenceManager("productos");
    static MongoDbCollectionPersistenceManager proveedoresCollectionManager = new MongoDbCollectionPersistenceManager("proveedores");

    /**
     * Establece conexión con la base de datos indicada en el fichero `mongodbconfig.properties`.
     * Crea la base de datos si no existe.
     * Reinicia la base de datos si existe.
     * Inserta las colecciones necesarias.
     */
    public static void creacion() {

        MongoDatabase database = MongoDbConnection.getInstance().getDatabase();
        database.drop();
        database.createCollection("clientes");
        database.createCollection("productos");
        database.createCollection("proveedores");
    }

    /**
     * Inserta los datos en las colecciones a partir de objetos java.
     * Los objetos java se han generado procedimentalmente.
     */
    public static void insercion() {

        Map<String, List<?>> datos = generarDatos();

        clientesCollectionManager.save((List<Object>) datos.get("clientes"));
        productosCollectionManager.save((List<Object>) datos.get("productos"));
        proveedoresCollectionManager.save((List<Object>) datos.get("proveedores"));
    }

    private static void consulta() {

        System.out.println("CONSULTA LOS CLIENTES");
        clientesCollectionManager
                .getCollection()
                .find()
                .forEach(System.out::println);
        System.out.println("\n");


        System.out.println("CONSULTA LOS CLIENTES CON NOMBRE \"Manuel\"");
        clientesCollectionManager
                .getCollection()
                .find()
                .filter(Filters.eq("nombre", "Manuel"))
                .forEach(System.out::println);
        System.out.println("\n");


        System.out.println("CONSULTA LOS PRODUCTOS");
        productosCollectionManager
                .getCollection()
                .find()
                .forEach(System.out::println);
        System.out.println("\n");


        System.out.println("CONSULTA LOS PRODUCTOS CON PRECIO >400€");
        productosCollectionManager
                .getCollection()
                .find()
                .filter(Filters.gt("precio", 400))
                .forEach(System.out::println);
        System.out.println("\n");


        System.out.println("CONSULTA LOS PROVEEDORES");
        proveedoresCollectionManager
                .getCollection()
                .find()
                .forEach(System.out::println);
        System.out.println("\n");


        System.out.println("CONSULTA LOS PROVEEDORES QUE VENDEN EXACTAMENTE 2 PRODUCTOS DISTINTOS");
        proveedoresCollectionManager
                .getCollection()
                .find()
                .filter(Filters.size("productos", 2))
                .forEach(System.out::println);
        System.out.println("\n");
    }

    private static void actualizacion() {

    }


    private static void agregacion() {

    }


    private static void exportacion() {

    }


    public static void main(String[] args) {

        creacion();

        insercion();

        consulta();

        actualizacion();

        agregacion();

        exportacion();

        MongoDbConnection.close();
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Simula obtención de datos de fuente de datos.
     *
     * @return mapa de datos
     */
    private static Map<String, List<?>> generarDatos() {

        Map<String, List<?>> datos = new HashMap<>();

        List<Cliente> clientes = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Proveedor> proveedores = new ArrayList<>();

        datos.put("clientes", clientes);
        datos.put("productos", productos);
        datos.put("proveedores", proveedores);


        // PRODUCTOS ////////////////////////////////
        Producto p1 = new Producto();
        p1.setId(1L);
        p1.setNombre("Impresora Epson 2000XT");
        p1.setCreateAt(2012);
        p1.setPrecio(250D);

        Producto p2 = new Producto();
        p2.setId(2L);
        p2.setNombre("Portátil Acer Aspire 5");
        p2.setCreateAt(2019);
        p2.setPrecio(650D);

        Producto p3 = new Producto();
        p3.setId(3L);
        p3.setNombre("Smartphone Samsung Galaxy S20");
        p3.setCreateAt(2020);
        p3.setPrecio(999D);

        Producto p4 = new Producto();
        p4.setId(4L);
        p4.setNombre("Tablet Apple iPad Pro");
        p4.setCreateAt(2018);
        p4.setPrecio(799D);

        Producto p5 = new Producto();
        p5.setId(5L);
        p5.setNombre("Monitor LG 27GL850-B");
        p5.setCreateAt(2021);
        p5.setPrecio(499D);

        Producto p6 = new Producto();
        p6.setId(6L);
        p6.setNombre("Teclado mecánico Corsair K95 RGB");
        p6.setCreateAt(2017);
        p6.setPrecio(189D);

        Producto p7 = new Producto();
        p7.setId(7L);
        p7.setNombre("Ratón inalámbrico Logitech MX Master 3");
        p7.setCreateAt(2020);
        p7.setPrecio(99D);

        Producto p8 = new Producto();
        p8.setId(8L);
        p8.setNombre("Altavoces para PC Logitech Z623");
        p8.setCreateAt(2012);
        p8.setPrecio(119D);

        Producto p9 = new Producto();
        p9.setId(9L);
        p9.setNombre("Auriculares inalámbricos Bose QuietComfort 35 II");
        p9.setCreateAt(2018);
        p9.setPrecio(299D);

        Producto p10 = new Producto();
        p10.setId(10L);
        p10.setNombre("Cámara DSLR Canon EOS Rebel T7");
        p10.setCreateAt(2019);
        p10.setPrecio(549D);


        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);
        ////////////////////////////////////////////


        // PROVEEDORES //////////////////////////////
        Proveedor pv1 = new Proveedor();
        pv1.setId(1L);
        pv1.setCif("3844775W");
        pv1.setNombreEmpresa("Industriales Paco");
        pv1.setDireccion("Rúa de Santo Tomás del Calvario");
        pv1.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5be1")
                )
        );

        Proveedor pv2 = new Proveedor();
        pv2.setId(2L);
        pv2.setCif("X6932050T");
        pv2.setNombreEmpresa("Electrónica López");
        pv2.setDireccion("Calle del Pilar");
        pv2.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5be2"),
                        new ObjectId("64037925b70f4469944a5be3")
                )
        );

        Proveedor pv3 = new Proveedor();
        pv3.setId(3L);
        pv3.setCif("A08857974");
        pv3.setNombreEmpresa("Insumos Express");
        pv3.setDireccion("Calle Mayor");
        pv3.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5be4"),
                        new ObjectId("64037925b70f4469944a5be5"),
                        new ObjectId("64037925b70f4469944a5be6")
                )
        );

        Proveedor pv4 = new Proveedor();
        pv4.setId(4L);
        pv4.setCif("G38502814");
        pv4.setNombreEmpresa("Distribuidora Gómez");
        pv4.setDireccion("Calle de la Luna");
        pv4.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5be7")
                )
        );

        Proveedor pv5 = new Proveedor();
        pv5.setId(5L);
        pv5.setCif("B28546936");
        pv5.setNombreEmpresa("Tecnología y Soluciones");
        pv5.setDireccion("Calle Mayor");
        pv5.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5be8"),
                        new ObjectId("64037925b70f4469944a5be9")
                )
        );

        Proveedor pv6 = new Proveedor();
        pv6.setId(6L);
        pv6.setCif("Z3938402X");
        pv6.setNombreEmpresa("Soluciones Informáticas");
        pv6.setDireccion("Avenida de la Constitución");
        pv6.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5bea"),
                        new ObjectId("64037925b70f4469944a5beb"),
                        new ObjectId("64037925b70f4469944a5bec")
                )
        );

        Proveedor pv7 = new Proveedor();
        pv7.setId(7L);
        pv7.setCif("J4811956E");
        pv7.setNombreEmpresa("Sistemas e Innovación");
        pv7.setDireccion("Calle de la Fuente");
        pv7.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5bed")
                )
        );

        Proveedor pv8 = new Proveedor();
        pv8.setId(8L);
        pv8.setCif("M6357849T");
        pv8.setNombreEmpresa("Tecnología Avanzada");
        pv8.setDireccion("Calle del Mar");
        pv8.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5bee"),
                        new ObjectId("64037925b70f4469944a5bef")
                )
        );

        Proveedor pv9 = new Proveedor();
        pv9.setId(9L);
        pv9.setCif("N4136209M");
        pv9.setNombreEmpresa("Suministros Técnicos");
        pv9.setDireccion("Calle de la Rosa");
        pv9.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5bf0"),
                        new ObjectId("64037925b70f4469944a5bf1"),
                        new ObjectId("64037925b70f4469944a5bf2")
                )
        );

        Proveedor pv10 = new Proveedor();
        pv10.setId(10L);
        pv10.setCif("H5793219X");
        pv10.setNombreEmpresa("Electrónica y Suministros");
        pv10.setDireccion("Calle del Sol");
        pv10.setProductos(
                List.of(
                        new ObjectId("64037925b70f4469944a5bf3"),
                        new ObjectId("64037925b70f4469944a5bf4")
                )
        );

        proveedores.add(pv1);
        proveedores.add(pv2);
        proveedores.add(pv3);
        proveedores.add(pv4);
        proveedores.add(pv5);
        proveedores.add(pv6);
        proveedores.add(pv7);
        proveedores.add(pv8);
        proveedores.add(pv9);
        proveedores.add(pv10);

        ;
        /////////////////////////////////////////////


        // CLIENTES ////////////////////////////////
        Cliente c1 = new Cliente();

        Ubicacion u1 = new Ubicacion();

        Factura f1 = new Factura();
        Factura f2 = new Factura();

        ItemFactura i1 = new ItemFactura();

        i1.setId(1L);
        i1.setCantidad(2);
        i1.setProducto(new ObjectId("64037925b70f4469944a5be1"));

        f1.setDescripcion("Compras de oficina");
        f1.setAnhoFactura(2022);
        f1.setObservacion("Pagado");
        f1.setId(1L);
        f1.addItemFactura(i1);
        f2.setDescripcion("Compras de hogar");
        f2.setAnhoFactura(2021);
        f2.setObservacion("Crédito");
        f2.setId(1L);

        u1.setDireccionFacturacion("Rúa San Pedro");
        u1.setDireccionPostal("Rúa San Pedro, 12");
        u1.setId(1L);
        u1.setCoordenadas("23.32n 12.22w");

        c1.setId(1L);
        c1.setNombre("Manuel");
        c1.setApellido("Landín");
        c1.setEdad(28);
        c1.setEmail("manuel@mail.com");
        c1.setUbicacion(u1);
        c1.addFactura(f1);
        c1.addFactura(f2);

        clientes.add(c1);

        Cliente c2 = new Cliente();

        Ubicacion u2 = new Ubicacion();

        Factura f3 = new Factura();

        ItemFactura i2 = new ItemFactura();

        i2.setId(2L);
        i2.setCantidad(1);
        i2.setProducto(new ObjectId("64037925b70f4469944a5bf1"));

        f3.setDescripcion("Compras de tecnología");
        f3.setAnhoFactura(2022);
        f3.setObservacion("Pagado");
        f3.setId(3L);
        f3.addItemFactura(i2);

        u2.setDireccionFacturacion("Calle Principal");
        u2.setDireccionPostal("Calle Principal, 123");
        u2.setId(2L);
        u2.setCoordenadas("32.11n 16.44w");

        c2.setId(2L);
        c2.setNombre("Ana");
        c2.setApellido("Pérez");
        c2.setEdad(35);
        c2.setEmail("ana@mail.com");
        c2.setUbicacion(u2);
        c2.addFactura(f3);

        clientes.add(c2);

        Cliente c3 = new Cliente();

        Ubicacion u3 = new Ubicacion();

        Factura f4 = new Factura();

        ItemFactura i3 = new ItemFactura();

        i3.setId(3L);
        i3.setCantidad(5);
        i3.setProducto(new ObjectId("64037925b70f4469944a5bf2"));

        f4.setDescripcion("Compras de alimentación");
        f4.setAnhoFactura(2022);
        f4.setObservacion("Pagado");
        f4.setId(4L);
        f4.addItemFactura(i3);

        u3.setDireccionFacturacion("Calle Mayor");
        u3.setDireccionPostal("Calle Mayor, 45");
        u3.setId(3L);
        u3.setCoordenadas("42.22n 8.23w");

        c3.setId(3L);
        c3.setNombre("Laura");
        c3.setApellido("García");
        c3.setEdad(42);
        c3.setEmail("laura@mail.com");
        c3.setUbicacion(u3);
        c3.addFactura(f4);

        clientes.add(c3);

        Cliente c4 = new Cliente();

        Ubicacion u4 = new Ubicacion();

        Factura f5 = new Factura();
        Factura f6 = new Factura();

        ItemFactura i4 = new ItemFactura();
        ItemFactura i5 = new ItemFactura();

        i4.setId(4L);
        i4.setCantidad(1);
        i4.setProducto(new ObjectId("64037925b70f4469944a5be2"));

        i5.setId(5L);
        i5.setCantidad(3);
        i5.setProducto(new ObjectId("64037925b70f4469944a5bf3"));

        f5.setDescripcion("Compras de libros");
        f5.setAnhoFactura(2022);
        f5.setObservacion("Pagado");
        f5.setId(5L);
        f5.addItemFactura(i4);

        f6.setDescripcion("Compras de ropa");
        f6.setAnhoFactura(2022);
        f6.setObservacion("Crédito");
        f6.setId(6L);
        f6.addItemFactura(i5);

        u4.setDireccionFacturacion("Avenida Principal");
        u4.setDireccionPostal("Avenida Principal, 123");
        u4.setId(4L);
        u4.setCoordenadas("40.55n 3.41w");

        c4.setId(4L);
        c4.setNombre("Javier");
        c4.setApellido("Martínez");
        c4.setEdad(25);
        c4.setEmail("javier@mail.com");
        c4.setUbicacion(u4);
        c4.addFactura(f5);
        c4.addFactura(f6);

        clientes.add(c4);

        Cliente c5 = new Cliente();

        Ubicacion u5 = new Ubicacion();

        Factura f9 = new Factura();
        Factura f10 = new Factura();

        ItemFactura i6 = new ItemFactura();

        i6.setId(1L);
        i6.setCantidad(1);
        i6.setProducto(new ObjectId("64037925b70f4469944a5be3"));

        f9.setDescripcion("Compra de muebles");
        f9.setAnhoFactura(2022);
        f9.setObservacion("Pagado");
        f9.setId(9L);
        f9.addItemFactura(i6);
        f10.setDescripcion("Compras de hogar");
        f10.setAnhoFactura(2021);
        f10.setObservacion("Crédito");
        f10.setId(10L);

        u5.setDireccionFacturacion("Rúa da Praza, 22");
        u5.setDireccionPostal("Rúa da Praza, 22");
        u5.setId(5L);
        u5.setCoordenadas("23.32n 12.22w");

        c5.setId(5L);
        c5.setNombre("Lucía");
        c5.setApellido("González");
        c5.setEdad(34);
        c5.setEmail("lucia@mail.com");
        c5.setUbicacion(u5);
        c5.addFactura(f9);
        c5.addFactura(f10);

        clientes.add(c5);

        Cliente c6 = new Cliente();

        Ubicacion u6 = new Ubicacion();

        Factura f11 = new Factura();
        Factura f12 = new Factura();

        ItemFactura i7 = new ItemFactura();

        i7.setId(2L);
        i7.setCantidad(3);
        i7.setProducto(new ObjectId("64037925b70f4469944a5be2"));

        f11.setDescripcion("Compra de electrónicos");
        f11.setAnhoFactura(2022);
        f11.setObservacion("Pagado");
        f11.setId(11L);
        f11.addItemFactura(i7);
        f12.setDescripcion("Compras de hogar");
        f12.setAnhoFactura(2021);
        f12.setObservacion("Crédito");
        f12.setId(12L);

        u6.setDireccionFacturacion("Rúa do Porto, 5");
        u6.setDireccionPostal("Rúa do Porto, 5");
        u6.setId(6L);
        u6.setCoordenadas("23.32n 12.22w");

        c6.setId(6L);
        c6.setNombre("Javier");
        c6.setApellido("Pérez");
        c6.setEdad(42);
        c6.setEmail("javier@mail.com");
        c6.setUbicacion(u6);
        c6.addFactura(f11);
        c6.addFactura(f12);

        clientes.add(c6);

        ////////////////////////////////////////////

        return datos;
    }
}

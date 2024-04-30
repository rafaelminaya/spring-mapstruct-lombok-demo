package com.rminaya.mapstructlombokdemo.mapper;

import com.rminaya.mapstructlombokdemo.dto.GetProduct;
import com.rminaya.mapstructlombokdemo.entity.Product;
import org.mapstruct.*;

import java.util.List;

/*
 * @Mapper
 * Anotación propia de MapStruct
 *
 * componentModel = MappingConstants.ComponentModel.SPRING
 * Permite registrar la implementación de esta interfaz como un componente en el "contenedor de spring"
 *
 * uses = {CategoryMapper.class}
 * Reemplaza el método "protected" generado para realizar un mapeo interno, por una inyección con @Autowired de esta interfaz "ProductMapper"
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {
    /*
     *
     * Generamos un método que me retorne una clase DTO(es decir una clase de domonio de la lógica del negocio)
     * Este método también podría llamarse "productToGetDTO()"
     * Ya que con el parámetro del método, se puede entender desde qué clase parte.
     *
     * @Mappings
     * Permite agregar varios "@Mappings" dentro
     * Podríamos omitir esta anotación y agregar varios "@Mapping"
     * Ya que de todas formas estos se realizan de forma automática en la clase que lo implementa.
     *
     * @Mapping
     * Permite realizar el mapeo de cada atributo.
     * Es opcional si los atributos se llaman igual.
     *
     * source = "id"
     * Indica de qué atributo de la clase se va a mapear
     * Requiere de tener al menos implementados los métodos "getters"
     *
     * target = "id"
     * Indica hacia qué atributo de la clase va a mapear
     * Requiere de tener al menos implementados los métodos "setters"
     *
     * dateFormat = "yyyy-MM-dd HH-mm-ss"
     * Formato de fecha a lo cual se va a mapear lo que reciba.
     * También se podrá ver en la clase que implementa la interfaz
     */
    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "creationDate", target = "creationDate", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "category", target = "productCategory"),
            /*
             * Internamente se casteará de BigDecimal a String
             *
             * numberFormat = "$#.00"
             * "DecimalFormat" de Java para formatear la cadena a que cumpla con la condición de: Tener al menos 1 número entero y al menos 2 decimales.
             */
            @Mapping(source = "price", target = "price", numberFormat = "$0.00")

            // Debemos agregar lo sgte., por cada atributo, en caso queramos omitir el "uses = {CategoryMapper.class}" más arriba
            //@Mapping(source = "category.id", target = "productCategory.categoryId"),
            //@Mapping(source = "category.name", target = "productCategory.categoryName"),
    })
    GetProduct toGetDTO(Product product);

    // Creación del mapeo inverso. toma la configuración del método arriba generando la inversa
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "creationDate", ignore = true) // Permite ignorar el atributo dado
    })
    Product toEntity(GetProduct getProduct);

    /*
     * Método para obtener una lista de "Product" DTO a partir de una lista de "Product" ENTITY
     * Este método internamente y de forma automática se apoyará con al método "productoToGetDTO()"
     * Puesto que con MapStruct se busca otro método en esta interfaz que haga lo mismo pero de forma individual,
     * es decir el método "productoToGetDTO()" y lo utiliza(en la clase concreta que implementa) para mapear en cada iteración.
     * @return
     */
    List<GetProduct> toGetProductList(List<Product> productList);

    // Se aplica lo mismo(List) para el caso inverso
    List<Product> toEntityList(List<GetProduct> getProductList);
}

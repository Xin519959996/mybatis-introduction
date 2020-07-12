import com.oak.mall.products.dao.impl.ProductJDBC;
import com.oak.mall.products.dao.impl.ProductMapper;
import com.oak.mall.products.entity.Product;
import org.junit.Test;

public class ProductRepositoryTest {

    @Test
    public void testFindByProductId() {
        ProductMapper productMapper = new ProductMapper();
        Product product = productMapper.findByProductId(1);

        ProductJDBC productJDBC = new ProductJDBC();

        Product product1 = productJDBC.findByProductId(1);

        System.out.printf("product_id = %d, product_name = %s, product_price = %s",
                product.getProductId(), product.getProductName(), product.getProductPrice());

        System.out.printf("\n---------------------------\n");

        System.out.printf("product_id = %d, product_name = %s, product_price = %s",
                product1.getProductId(), product1.getProductName(), product1.getProductPrice());
    }

}

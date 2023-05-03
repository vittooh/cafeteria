package mercadinho.br;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("/v1/produtos")
@RestController
public class MercadinhoController {


    private final HashMap<String, ProdutosDto> produtos;

    public MercadinhoController() {
        produtos = new HashMap<>();
        produtos.put("ARROZ",new ProdutosDto("ARROZ",5000L,new BigDecimal("25.0")));
        produtos.put("AÇUCAR",new ProdutosDto("AÇUCAR",5000L,new BigDecimal("25.0")));
        produtos.put("FEIJAO",new ProdutosDto("FEIJAO",5000L,new BigDecimal("25.0")));
        produtos.put("CAFE",new ProdutosDto("CAFE",5000L,new BigDecimal("25.0")));
    }

    @GetMapping("/{produto}")
    ProdutosDto getProdutos(@PathVariable("produto") String produto) {
        return produtos.get(produto.toUpperCase());
    }
}

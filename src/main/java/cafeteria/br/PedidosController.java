package cafeteria.br;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

@RequestMapping("/v1/produtos")
@RestController
public class PedidosController {

    private final HashMap<String, ProdutosDto> produtos;

    private final Counter cafeMineiro;
    private final Counter cafePaulista;
    private final Counter paoQueijo;
    private final Counter broa;

    Random rand = new Random();


    public PedidosController(MeterRegistry meterRegistry) {
        produtos = new HashMap<>();
        produtos.put("CAFE_MINEIRO",new ProdutosDto("Café Mineiro",5000L,new BigDecimal("25.0")));
        produtos.put("CAFE_PAULISTA",new ProdutosDto("Café Paulista",5000L,new BigDecimal("25.0")));
        produtos.put("PAOQJ",new ProdutosDto("Pão de queijo",5000L,new BigDecimal("25.0")));
        produtos.put("BROA",new ProdutosDto("Broa",5000L,new BigDecimal("25.0")));
        cafeMineiro = meterRegistry.counter("cafeMineiro");
        cafePaulista = meterRegistry.counter("cafePaulista");
        paoQueijo = meterRegistry.counter("paoQueijo");
        broa = meterRegistry.counter("broa");
    }

    @GetMapping("/{produto}")
    @Timed(value = "getProdutos")
    ProdutosDto getProdutos(@PathVariable("produto") String produto) throws InterruptedException {
        Thread.sleep(rand.nextInt(10));
        switch (produto.toUpperCase()){
            case "CAFE_MINEIRO":
                cafeMineiro.increment();
                break;
            case "CAFE_PAULISTA":
                cafePaulista.increment();
                break;
            case "PAOQJ":
                paoQueijo.increment();
                break;
            case "BROA":
                broa.increment();
                break;
            default:
                System.out.println("q issu? " + produto);
        }
        return produtos.get(produto.toUpperCase());
    }
}

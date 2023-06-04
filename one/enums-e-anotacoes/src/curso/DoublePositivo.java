package curso;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// declarar uma anotação: @ + interface
@Retention(RetentionPolicy.RUNTIME) // é obrigatório declarar o runtime da anotação (onde ela é válida)
@Target(ElementType.FIELD) // é obrigatório declarar o target da anotação (onde ela atua)
public @interface DoublePositivo {
  // anotações não tem implementação; elas são apenas declarações que precisam ser interpretadas
  // (neste caso não possui nenhuma declaração, é apenas para fins didáticos);
}

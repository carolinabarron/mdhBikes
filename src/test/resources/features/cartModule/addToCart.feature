Feature: Agregar articulos al carrito de MDH

  Scenario: Buscar artículo y agregarlo al carrito de la página mdh
    Given El usuario navega a la pagina de home
    When Introduce criterio de busqueda
    And Selecciona el primer articulo de la pagina de resultados
    And Agrega el primer articulo al carrito
    Then El articulo es agregado al carrito
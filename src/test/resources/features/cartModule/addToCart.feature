Feature: Agregar articulos al carrito de MDH

  Scenario Outline: Selecciona un articulo y lo agrega al carrito de la pagina mdh
    Given El usuario selecciona un "<articulo>"
    When Lo agrega al carrito
    Then El articulo es listado en la pagina de carrito

    Examples:
      | articulo               |
      | M1 Helmet              |
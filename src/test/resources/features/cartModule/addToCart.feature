Feature: Agregar articulos al carrito de MDH
#Parametrizacion es recomendada
  Scenario: Selecciona un articulo y lo agrega al carrito de la pagina mdh
    Given El usuario selecciona un articulo
    When Lo agrega al carrito
    Then El articulo es listado en la pagina de carrito
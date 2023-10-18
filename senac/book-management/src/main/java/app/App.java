package app;

import views.MainMenu;

public class App {
	public static void main(String... args) {
    /*
    - Nacionalidade como ENUM;
    - refatoração:
    	- utilizar document (?) para permitir valores vazios no preço e na data de compra
      - remover atributos desnecessários;
      - deixar horizontal e vertical size como default (responsividade);
      - avaliar se deve ser utilizado preferred size
    - avaliar a utilização de interfaces para Services e Controller;N
    - Testar conversão e valição de ISBN
     */

    var menu = new MainMenu();
    menu.setVisible(true);

//    FormatController formatController = new FormatController(j);
//    CategoryController categoryController = new CategoryController();
//    AuthorController authorController = new AuthorController();
//    BookController bookController = new BookController();
//
//    var papperback = formatController.create("Papperback");
//    var ebook = formatController.create("Ebook");
//
//    var romance = categoryController.create("Romance");
//    var journalism = categoryController.create("Journalism");
//    var brazillian = categoryController.create("Brazillian Literature");
//    var german = categoryController.create("g");
//
//    var euclides = authorController.create(new AuthorDto("Euclides da Cunha", "Brasileiro"));
//    var goethe = authorController.create(new AuthorDto("Johann Wolfgang von Goethe", "German"));
//    var larson = authorController.create(new AuthorDto("erick larssonn", "americano"));
//
//    HashSet<Category> categoriesSertoes = new HashSet<>();
//    HashSet<Category> categoriesWerther = new HashSet<>();
//    HashSet<Category> categoriesWhiteCity = new HashSet<>();
//
//    categoriesSertoes.add(journalism);
//    categoriesSertoes.add(brazillian);
//
//    categoriesWerther.add(romance);
//    categoriesWerther.add(german);
//
//    categoriesWhiteCity.add(journalism);
//
//    var sertoes = bookController.create(
//            new BookDto("Os Sertões", "1234567384937", 659, euclides, ebook, LocalDate.of(2023, 2, 12), 7.59f),
//            categoriesSertoes);
//    var werther = bookController.create(new BookDto("Os Sofrimentos do Jovem Werther", "7463527183627", 191, goethe,
//            papperback, LocalDate.of(2022, 9, 12), 12.75f), categoriesWerther);
//    var whiteCity = bookController.create(
//            new BookDto("whitecity", "654", 626, euclides, papperback, LocalDate.of(2022, 3, 21), 16f), categoriesWerther);
//
//    formatController.update(ebook.getId(), "e-book");
//
//    categoryController.update(german.getId(), "German Literature");
//
//    authorController.update(larson.getId(), new AuthorDto("Erik Larson", "American"));
//
//    bookController.update(whiteCity.getId(), new BookDto("The Devil in the White City", "0182635799221", 626, larson,
//            ebook, whiteCity.getPurchaseDate(), 16f), categoriesWhiteCity);
//
//    bookController.getAll().forEach(System.out::println);
//
//    bookController.delete(sertoes.getId());
//    bookController.delete(werther.getId());
//    bookController.delete(whiteCity.getId());
//
//    authorController.delete(euclides.getId());
//    authorController.delete(goethe.getId());
//    authorController.delete(larson.getId());
//
//    categoryController.delete(journalism.getId());
//    categoryController.delete(romance.getId());
//    categoryController.delete(brazillian.getId());
//    categoryController.delete(german.getId());
//
//    formatController.delete(papperback.getId());
//    formatController.delete(ebook.getId());
  }
}

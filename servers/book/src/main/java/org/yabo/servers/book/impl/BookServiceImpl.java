package org.yabo.servers.book.impl;

import org.springframework.stereotype.Service;
import org.yabo.common.Code;
import org.yabo.common.Result;
import org.yabo.common.beans.Book;
import org.yabo.service.book.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Override
    public Result<Book> getBook(String isbn) {
        Book book = new Book();
        book.setId(1L);
        book.setIsbn("isbn:" + isbn);
        book.setName("天龙八部");
        book.setStatus(Book.Status.PAID);
        return Result.of(book).code(Code.SUCCESS).message("success");
    }
}

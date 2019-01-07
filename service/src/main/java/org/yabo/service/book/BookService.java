package org.yabo.service.book;

import org.yabo.common.Result;
import org.yabo.common.beans.Book;

public interface BookService {
    Result<Book> getBook(String isbn);
}

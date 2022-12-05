select * from books;
select  * from book_categories;

select count(*) as borrowedBooks from users u
inner join book_borrow bb on u.id = bb.user_id
where is_returned=0;


select  name from book_categories;



select name,author,isbn,year,book_category_id, description from books;
select name from book_categories;

select b.name as name ,author,isbn,year,bc.name as category,b.description as description from books b
inner join  book_categories bc on b.book_category_id = bc.id
where b.name='Chordeiles minor';




select b.name as name ,author,isbn,year,bc.name as category,b.description as description from books b
 inner join  book_categories bc on b.book_category_id = bc.id
where b.name='Chordeiles minor';

select bc.name ,count(*)  from book_borrow bb
inner join books b on bb.book_id = b.id
inner join book_categories bc on b.book_category_id = bc.id
group by name
order by 2 desc limit 1;

select b.id as id,b.name as name ,author,isbn,year,bc.name as category from books b
inner join  book_categories bc on b.book_category_id = bc.id
where b.name = 'The Scrum Field Guides' and author='Mitch Laceys'
order by b.id desc ;
@Repositorypublic interface BlogRepository extends JpaRepository<Blog, Long>{    Blog findByBlogId(Long blogId);}
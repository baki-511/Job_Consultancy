
      $(document).ready(function () {
        $(".testimonial-content").owlCarousel({
          loop: true,
          nav: false,
          dots: true,
          margin: 50,
          autoplay:true,
          autoplayTimeout:4000,
          smartSpeed:800,
          responsive: {
            0: {
              items: 1,
            },
            600: {
              items: 1,
            },
            1000: {
              items: 1,
            },
          },
        });
      });


package com.domain.models

data class Dish(
    val dishId: Int,
    val name: String,
    val description: String,
    val price: Int,
    val image: String,
    val isVeg: Boolean,
    val spicyLevel: Int,
    val discount: Int,
    val quantity: Int = 0,
)

val triedTastedLoved =
    listOf(
        Dish(
            1,
            "Spicy Inferno",
            "A fiery explosion of flavors made from chili-laced sauce, grilled chicken, jalapeños, and red-hot seasoning nestled in toasted buns. Perfect for spice enthusiasts seeking a kick.",
            190,
            "burger",
            false,
            5,
            15,
        ),
        Dish(
            2,
            "Green Garden Delight",
            "A wholesome blend of steamed broccoli, fresh lettuce, and cottage cheese tossed with herbs and served on a multi-grain base. A refreshing light meal.",
            130,
            "burger",
            true,
            2,
            0,
        ),
        Dish(
            3,
            "Tandoori Crunch",
            "Smoky tandoori-marinated chicken breast served on a crisp garlic naan with onion rings, mint chutney, and tangy yogurt drizzle. Crunchy, creamy, and irresistible.",
            160,
            "burger",
            false,
            4,
            30,
        ),
        Dish(
            4,
            "Butter Bliss",
            "A classic rich blend of butter paneer curry enveloped in soft naan bites, delivering the comforting warmth of Indian spices in a portable snack.",
            150,
            "burger",
            true,
            3,
            50,
        ),
        Dish(
            5,
            "Chili Bomb",
            "Exploding with chili heat and smoky goodness, this dish packs a punch with crushed chili peppers, shredded chicken, and spicy aioli wrapped in a soft tortilla.",
            120,
            "burger",
            false,
            5,
            15,
        ),
        Dish(
            6,
            "Paneer Royale",
            "Melt-in-mouth paneer cubes marinated in royal spices, grilled to perfection, layered over saffron rice and served with mint-infused yogurt dip.",
            170,
            "burger",
            true,
            3,
            0,
        ),
        Dish(
            7,
            "Garlic Overload",
            "An intense garlic experience with double-roasted garlic spread, garlic butter grilled chicken, and fried garlic chips — not for the faint of breath!",
            140,
            "burger",
            false,
            4,
            15,
        ),
        Dish(
            8,
            "Cheese Volcano",
            "A molten explosion of cheddar, mozzarella, and gouda oozing from a crispy-fried patty, topped with jalapeño salsa and served inside butter-toasted buns.",
            180,
            "burger",
            true,
            2,
            30,
        ),
        Dish(
            9,
            "Minty Tango",
            "A cool, creamy fusion of fresh mint leaves, yogurt dip, cucumber slices, and herb rice rolled inside a soft paratha — tangy and refreshing.",
            110,
            "burger",
            true,
            1,
            0,
        ),
        Dish(
            10,
            "Firecracker Wings",
            "Crispy chicken wings glazed with a spicy sriracha-barbecue blend, dusted with chili flakes, and served with a side of pickled slaw. Pure fire.",
            190,
            "burger",
            false,
            5,
            50,
        ),
        Dish(
            11,
            "Lemon Herb Biryani",
            "Zesty lemon-infused rice tossed with herbs, caramelized onions, and marinated paneer. Served with raita and a slice of lemon. Fragrant and bold.",
            170,
            "burger",
            true,
            3,
            15,
        ),
        Dish(
            12,
            "Smoky Feast",
            "A meat lover’s dream featuring smoked lamb chunks, tangy BBQ glaze, fire-grilled peppers, and crispy onions stuffed in a large roll.",
            200,
            "burger",
            false,
            4,
            0,
        ),
        Dish(
            13,
            "Royal Rajma",
            "Creamy kidney beans cooked in rich tomato gravy, layered with jeera rice and served in a clay pot. A comforting royal north-Indian treat.",
            140,
            "burger",
            true,
            2,
            30,
        ),
        Dish(
            14,
            "Kung Pao Paneer",
            "Crispy paneer cubes stir-fried with bell peppers, roasted peanuts, and spicy Kung Pao sauce. Served with fried rice or noodles.",
            160,
            "burger",
            true,
            4,
            50,
        ),
        Dish(
            15,
            "Zesty Chicken Pop",
            "Juicy boneless chicken bites coated in lemon chili seasoning, flash-fried until crispy and served with garlic mayo dip.",
            150,
            "burger",
            false,
            3,
            15,
        ),
    )

val lookingForMore =
    listOf(
        Dish(
            16,
            "Crackling Corn",
            "Golden sweet corn kernels fried to a perfect crunch, tossed in tangy spices and garnished with fresh coriander.",
            130,
            "burger",
            true,
            3,
            15,
        ),
        Dish(
            17,
            "Masala Magic",
            "A robust mix of Indian spices rubbed over paneer cubes, grilled and served with spicy tomato-onion relish.",
            140,
            "burger",
            false,
            4,
            30,
        ),
        Dish(
            18,
            "Herbed Cottage",
            "Creamy cottage cheese infused with oregano, thyme, and parsley, served hot on a garlic-butter flatbread.",
            160,
            "burger",
            true,
            2,
            0,
        ),
        Dish(
            19,
            "Dragon Fire Rice",
            "Flame-fried rice tossed with spicy dragon sauce, bell peppers, and chicken bites — hot, bold, and exciting.",
            170,
            "burger",
            false,
            5,
            50,
        ),
        Dish(
            20,
            "Makhani Bowl",
            "Silky tomato-butter gravy with paneer cubes served over steamed rice and topped with cream drizzle.",
            150,
            "burger",
            true,
            3,
            15,
        ),
        Dish(
            21,
            "Crunchy Manchurian",
            "Crispy veg balls dipped in spicy Indo-Chinese Manchurian sauce, served sizzling with scallions.",
            120,
            "burger",
            true,
            4,
            0,
        ),
        Dish(
            22,
            "Fusion Frankie",
            "Grilled wraps filled with spicy shredded chicken, lettuce, and mayo wrapped in a flaky egg paratha.",
            140,
            "burger",
            false,
            3,
            15,
        ),
        Dish(
            23,
            "Bombay Toastie",
            "Layered potato masala, chutney, cheese, and onions between grilled bread — a Mumbai street food classic.",
            110,
            "burger",
            true,
            2,
            30,
        ),
        Dish(
            24,
            "Peppery Crunch",
            "Crusted chicken patties coated in black pepper spice blend, grilled and served with spicy mayo.",
            130,
            "burger",
            false,
            4,
            50,
        ),
        Dish(
            25,
            "Silky Shahi Paneer",
            "Velvety shahi gravy made with cashew cream, saffron, and paneer chunks, served with jeera rice.",
            180,
            "burger",
            true,
            3,
            0,
        ),
        Dish(
            26,
            "Loaded Nachos",
            "Crunchy tortilla chips topped with spicy beans, sour cream, jalapeños, guac, and melted cheese.",
            150,
            "burger",
            true,
            3,
            15,
        ),
        Dish(
            27,
            "Tangy Chicken Fry",
            "Fried chicken bites coated in a tangy, spicy tomato glaze with hints of garlic and lime.",
            170,
            "burger",
            false,
            5,
            30,
        ),
        Dish(
            28,
            "Creamy Corn Cup",
            "Warm sweet corn mixed with melted butter, cream, and a pinch of pepper — comfort in a cup.",
            110,
            "burger",
            true,
            1,
            0,
        ),
        Dish(
            29,
            "Peri Peri Punch",
            "Peri-peri spiced potato wedges, fried to golden perfection and served with a side of cheesy dip.",
            140,
            "burger",
            false,
            4,
            50,
        ),
        Dish(
            30,
            "Paneer Lavash",
            "Thin lavash wraps loaded with grilled paneer tikka, pickled onions, and spicy yogurt sauce.",
            160,
            "burger",
            true,
            3,
            15,
        ),
    )

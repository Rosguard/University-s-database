<template>
    <div class="pageClass">
        <!--        <iframe width="560" height="315" src="https://www.youtube.com/embed/NYDlPg14dGQ" frameborder="0"-->
        <!--                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"-->
        <!--                allowfullscreen></iframe>-->
        <!--        <iframe src="//coub.com/embed/9ub090?muted=false&autostart=false&originalSize=true&startWithHD=true"-->
        <!--                allowfullscreen frameborder="0" width="960" height="960" allow="autoplay"></iframe>-->
        <v-carousel cycle height="550"
        >
            <v-carousel-item

                    v-for="(item,i) in items"
                    :key="i"
                    :src="item.src"
                    reverse-transition="fade-transition"
                    transition="fade-transition"
            ></v-carousel-item>
        </v-carousel>
    </div>
</template>

<script>
    import LeftMenu from "../components/LeftMenu.vue";

    export default {
        name: "MainPage",
        components: {LeftMenu},
        data() {
            return {
                dialog: false,
                items: [
                    {
                        // src: 'https://media.giphy.com/media/26tn5EPJlbNt8CFkk/giphy.gif'
                        src: 'https://nsu.ru/rs/mw/link/Image:/58132/8iHugEIXh_o.jpg'
                    },
                    {
                        src: 'https://nsu.ru/rs/mw/link/Image:1000px-/44821/IMG_3295.jpg'
                    },

                ],
            }
        },


    }
</script>

<style scoped>
    .pageClass {
        background: rgba(135, 245, 240, 0.85);
        height: 100%;
    }
</style>
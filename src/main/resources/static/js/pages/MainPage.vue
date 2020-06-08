<template>
    <div class="pageClass">
<!--        <iframe width="560" height="315" src="https://www.youtube.com/embed/NYDlPg14dGQ" frameborder="0"-->
<!--                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"-->
<!--                allowfullscreen></iframe>-->
        <v-carousel cycle height="900"
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
                        src: 'https://media.giphy.com/media/26tn5EPJlbNt8CFkk/giphy.gif',
                    },
                ],
            }
        },


    }
</script>

<style scoped>
    .pageClass {
        background: rgba(128, 128, 128, 0.89);
        height: 100%;
    }
</style>
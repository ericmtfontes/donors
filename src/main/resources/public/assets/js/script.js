const api = axios.create({
    baseURL: 'http://localhost:8080/donors'
});

$(function() {
    const app = new Vue({
        el: "#app",
        data: {
            amountPerState: [],
            averageImcByAge: [],
            percentageObese: [],
            averageByBloodType: [],
            potencialDonorsByType: [],
            json : "",
            enviando: false
        },
        methods: {

            init : function(){
                this.getAmountPerState();
                this.getAverageImcByAge();
                this.getPercentageObese();
                this.getAverageByBloodType();
                this.getPotencialDonorsByType();
            },

            process: async function () {
                if(this.json == ""){
                    alert("Por favor informe o conteudo")
                    return 
                }

                try{
                    JSON.parse(this.json)
                } catch(e){
                    alert("Informe um json válido")
                    return 
                }
                this.enviando = true
                const r = await api.post("", this.json, {
                    headers: {
                        'Content-Type': 'application/json',
                    }
                })
                this.enviando = false
                if(r.status == 201){
                    this.json = "";
                    $('#modalProcess').modal('toggle');
                    alert("Dados processados com sucesso");
                    this.init();
                }
                else {
                    alert("Erro ao processar esses dados")
                }
            },

            getAmountPerState: async function () {
                const r = await api.get("/amount-per-state")
                if(r.status == 200){
                    this.amountPerState = r.data
                }
            },

            getAverageImcByAge: async function () {
                const r = await api.get("/average-imc-by-age")
                if(r.status == 200){
                    this.averageImcByAge = r.data
                }
            },

            getPercentageObese: async function () {
                const r = await api.get("/percentage-obese")
                if(r.status == 200){
                    this.percentageObese = r.data
                }
            },

            getAverageByBloodType: async function () {
                const r = await api.get("/average-by-blood-type")
                if(r.status == 200){
                    this.averageByBloodType = r.data
                }
            },
            // 

            getPotencialDonorsByType: async function () {
                const r = await api.get("/potential-donors-by-type")
                if(r.status == 200){
                    this.potencialDonorsByType = r.data
                }
            },

        },
    });

    app.init()
})
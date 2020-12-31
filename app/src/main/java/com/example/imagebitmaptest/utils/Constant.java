package com.example.imagebitmaptest.utils;

import android.os.Environment;

public class Constant {
    public static final String PHOTO_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + "/BOSPad/photos/";
    public static final String XYD_PHOTO_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + "/BOSPad/xydPhotos/";
    public static final String ITM_PHOTO_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + "/BOSPad/itmPhotos/";


    public static final String base64Url="iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAYAAACtWK6eAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\n" +
            "CHwIZIgAABHzSURBVHic7Z17sF5VdcB/JDcRAgQIr5AYEtsKgSDEDg8fVMCUqvjAjjBQbW2ddtrR\n" +
            "gq31UZs6OnRqZ3y1isUSkIZqEREflFYB+yAWsRQYAlKEhldijAgSQpLmdXPv3f1jfYd7k3yv/T77\n" +
            "nPWb+eYy4dt7r++cs87ee+31AEVRvJnb+SiK0oXNwKbcQihKXTGdzxG5BVGUOnIZoiC35RZEUerK\n" +
            "BKIkiqJ04WJEQT6dWxBFqSP7IQoynlsQRakrNyFKclZuQRSlrhhkP6IojWeaQ5t7keXWksCyKEpj\n" +
            "mAC25xZCUerKCtTkqyh9GQO+mVsIRakrZyNKoiiNZbpH27XAQmAd8HQQaRSlgdydWwBFqTOHAYfn\n" +
            "FkJR6sxjuQVQFEVRErNfbgGUIpgBnIAsp08HlgHzgBcDByLWzJ3AQ8CtwCpgNbAjg6yKkoQR4BDE\n" +
            "WmmmfCYQj+5RYBsSij31s73z/w3wPkS5FKVRLAaeYjJIzgAbgA8jpv0FwFHAQV3azu78/ys77Z7u\n" +
            "fFdRGsFHEcWYAK4FLgAOdezrpcDtyFLLtQ9FqQ2vQN76dyD7i1DchmTGUZSi2QncE6lvg84iSuHE\n" +
            "9NCeAN4WsX9FicpJxPWpuw24P2L/ihKVNcDHIvb/agoM1XYJuVWayRzg2Yj9r6fAg2lVkH25KrcA\n" +
            "mbgSOQGPhcYONYBPoKHEsTiGAq+tziB7clhuARpMcfsPZV/OoMC3XCHMQ69tI9CbGIcXU+C11SWW\n" +
            "kgqf/AfZUAVRUnF6bgGUMBS3DCiEB9Fr2wj0JsZhNwWehegSS0nFCPBAbiFsUQVRUvL13ALYogrS\n" +
            "nXNzC9BQHsotgC2qIN15VW4BGsr63AIo/hjgvtxCNIxZyHWdmVsQW3QG6c6BuQVoGBd1/o5mlcIB\n" +
            "VZDuhExYoMDS3AIo4dAipeF5Ei0f3hiqRGlKOMaBjbmFcEGXWEoKpiGZGpUGUIcZ5EhgPpLGswkY\n" +
            "4HdzC6GEIbWCzERy2V6MpOg0XT7PAL9GuTluc79wlICkVJDlwBYms6EP+owCH08kW0hUQRpECgX5\n" +
            "EyRJWzXWDuALwPnAWUxmUH8Jcqr/FuDbU77/RYcxbwFO9hXcgfehCtIoYivIVVPGuJHJQ7RhWAA8\n" +
            "jJt824BTHNr58lNUQRpFTAX5u07f64EzPfoZx37TewV5FGQnBcaBKL2JpSDndvp9PkBf12Of5/Z6\n" +
            "8ijIBAX7tuk5SDpu6fw9JkBfdwPHWbbJlfNrP+C6TGN7MxKx70ORmzIdsdQ8E3GsunMBch1+mTCF\n" +
            "LR8H9rdskyMv7uGdv3dlGDsIvgpyPLKWPhZxSDsFOeCazp43pPJtGgO2IsuDOxGl+RaykWsyH0Su\n" +
            "wepA/f0M+wd+TqCxbTin8/fODGNnYSaSvuVDwM+ZXK/vRjaetwNfBX4HOJF9l3DzgNcB7we+BvwP\n" +
            "UhX1e8Bp0aUfjhh7kI3AfwbsbyH2Mq4j/R7kH2mJBWs28Fn2LAW8Dbnobw7Q/3JEUXZgv3QITQwF\n" +
            "GQVWBuzvVOw9jh8lvYLspuEKMhdZ71Y/1CCVghbRvQSwD7OBvwSeC9yvLTEU5HngmoD9vRd70+kO\n" +
            "0itIHfzaojAb+A6TP/Ap4E2kWce+gXiFJIchxk19JWEdDz+NGD5sGCOPgvwk8ZjR+QMmfYM2IG+r\n" +
            "1DyRYcyKEt561wJrLdsY8ijI+YnHjMrNyI/aQl6nuHnkKxlcgoJsAO61bGNI64t1YGfMgxOOGZUr\n" +
            "kB8Us07dsByEWLtyUIKCTCDmcRsM8LIIsvTic50xi6tL2ItnEPt6zMPDYdmffGbfEhTEIJYs2zaL\n" +
            "I8jSi+9R/+toxUm5BZjCwcBrM41dioK4tPnF0IL0YTOa/CIa1yEn8jlosoIsCC1IHyaQbCZKBHK+\n" +
            "eequINXm1xZDWodFA1ydcLwo1NGb95eAXbmFqDF/6tHW9uzElSrF6P8mGq9VPA2cnXH8us8g/4fb\n" +
            "DJvyNy3ujDcj4ZitYAn5N3Z1V5AqItGlXSo0Dj0Su4BPWrZ5a2AZSlCQqxzbpeK5xOO1giXYX9Tq\n" +
            "YQ55ZlKCgrgkYUv5mzS/cQQM9qGZU3NGhZSj7gqy0LJNVZ8jFQZ4JOF4jec03NwSqpxSBgnCCkGd\n" +
            "FeQA3GQ7m7RvdAO8MeF4jWczEoloyybEAW8L4R7qOitIlRnFlg+T1nRukHBsJQCn4/9Azu/0EeL0\n" +
            "vc4Kcilusl2OhEin4K2IjHU8YysSgwQA+bIdew/XbtR5g3kPbgqyEvhRYFl68bfU9wVTHMcT7m3z\n" +
            "GcJUMTLUNxPgLtx+43eBVWFF6ck66vuCKY5nCZsSJoSyVVla6ohBMoXYsga4NbAsvZjAPtpR6cKh\n" +
            "hJ+KQ0TNGepbLswg0Za27AC+HFiWXhjCpjhqLZuB7wfu80n8XawN9rNaqnBW1xfKBPCekIL0wSDF\n" +
            "fhQPqtkjdD3y38B/VjLIRtO2zW97jjvsOK7tZoUUZMBYjSGXKe4RZCO8LXC/NwXqZ41Dm9gbe988\n" +
            "ZNuDSNGfJQnGaAWGePX2fN5g1Um17XmKAS70GHcYLsdvBknBjxOOlYQcM8hDSLLqWNnefW5QlQhh\n" +
            "g0Pb2NfyTCSFqS0pYzIWoArixQFIUut3RBxjHPep/jyPcWNng5mP29LvgNCCDMAlVqW2pFaQf0Ae\n" +
            "4FURx9gKvNyx7SKPcWcO/ooXR+KWkrWaQaYjXsAfQWbxnci+5HNI+YpQ/HXAvlqHAc6IPMbDwB85\n" +
            "tv067gkRQhkI+o3xCYd27++0fR4x95ounwnk0NbXEKBevB58kjCuIINYCvy5Y9s7cFcQ21SgLmO4\n" +
            "HBI+Snel6PbZBbzbUb6XdvqoQ+LBYKT8MR8gTb7f+3FXEJ/aJEd7tB1ElRnepRJXt2Rx40gWzZ8h\n" +
            "bjXTkJCBEWR/OAP4J8SvalgqA0dd/dhqzUWktW7c4dhuNe4zSIjag704ET8T72rEAvYl4u2VvkbD\n" +
            "LFgpMcgFTIVrfZH7cVeQmA/HhR79G+DigLL0YjfqxevE2chNSllazbVK1TrqqSCPefRvgJcElKXf\n" +
            "OI0rlpOCp5FkZynZ5NhuI/VUkAncsyKmWvYYZKOuWDAHuXCHJB53rWO7KgGELZX5NBY+UZcpFUSx\n" +
            "5GHE/p6aFY7tqtJztow5thsWg1v5tFeQZl8wk4YqSEwz73QkR2tsJ75u3OjYztWzIIVHgovn82tI\n" +
            "Y3b9swRjNI6ryfdWme7YzjUePcUM4lLKbAVpZvDVtMiC9THCVEN1dY3IicFtg7+ZeApyjkffG4D/\n" +
            "DihLL7Yiy+nGsxS5GePAXI9+zuv086IQQiXE4FbT4kniKcjf4P52niBNKPAEDSiWMwzjTFpkfDJ7\n" +
            "bAEeDyJRWgzwbYd29xFPQf4Z8bx1IaUFK3SW/VoyhsR1b0B+9HKHPiqLxpEB5UqFQZKs2RKzoutG\n" +
            "5KDQhRQKMiPROLVgMWKRmYHMJi4b1rsd2+VmBLnRVzi0vYt4D8kE8B+ObVM8uNWyvJHsbZ58BLkh\n" +
            "u4FliDXoC5Z9nkaZ0+0Rnb82HqwVz4YUZC/2wy0IKUbesW60OlFD5bw3rNn0PMqcPWAyDeo5Dm2/\n" +
            "SbyH0bXfy0njG/VDGjyDDKJ6C31myO8/B1wWT5yovAz3G327R9t+VMs+F36CfTk7Fwzpfe1qhY0j\n" +
            "XslvklNwl/8Wj7b9ONij31HSeDEYZLZqLUcz3Ob1BmSpUSofwv1hdA3VHcQhHv1OkCZi1NVPrFE8\n" +
            "y2Bb/BjyxiuVf8f9YXzCo20/bvXoN+UZyOGJxqotv0r/jCSvQuI+SsanjFusjII7cLOqVQaH2KSy\n" +
            "lBXBNnrPIs/QPTlASfgEPT3o0bYfBln62fJ20jgP/jGqIC9wHL0vRop0PrHxUZD1Hm37YXDbaK8G\n" +
            "/jWwLN1YSX2LDQXBZhO3Bsmb9DBwwpR/vx74/ZBCFUiVcG014oUwq/NvBjmMnYZkMRxD3M/HkCQW\n" +
            "nxqib5d8W6eQ5gDvXNycOxtLlV1j6gl8E2YPcJ9BVkxp6/K5DwkLWNRDJhcM/lkSh2GcdKXdimEc\n" +
            "qbsN4o7SFDdng1st8b0f+MpVZydSenlD5+86xNr1QyRm/kdI4rY1iOfzeuBmpDrTtCl9u5DSgvWu\n" +
            "RGMVwzuZvAGpbO0pqN7mtowyGR4Qwty5DLiy09cwG+0DEAX8dcR6ddCQ7UKgG/QeGOBtNGv9aZBo\n" +
            "Sluq025Xl/ReXMBwcSDfYt9ZLFbtlak0NlFDCJYjb8zUtSdi4nMibICvBpQF4FKGO1vqtbcZA36A\n" +
            "m/v+MMxGFaQvJYbU9uJY5Pe4Wn4MciYQki8BfzXk2IM+40jo7vkB5Xs7qiA9uRqJE7krtyCBuBS5\n" +
            "2Qsc2xvgt8KJA4h7zzAzdOVuPuznCWQf6bt3rOqNKHsxDUmND/uafEvlGuS3uNbzM8AbwonzQp/D\n" +
            "8AtMph2y+YwDl+BuWDC4Z7BsNB9nMkfTN5C3UemsxG+5YJB4kpDYyDMb8fz9LvaKshN4APtcYgaZ\n" +
            "eZW9+M0p/z0Dt7ODuvFf+CtIaHO3izwbkX3LGcBZyINvM7s8wPDhvQZ4k4OMRWGbre8vgI/u9W9f\n" +
            "ROJAvhNEojxsQjxTXbIXgjwsrm1D9mmAV7Lv3vAo4HSkiOf0Tr9zEf+6Rcgy63BEyfdHIkNvQO51\n" +
            "r3h7AxxGntzLybC9AUuQCql78zhle/OOMekz5UIMBXkU+3ICoeQ4AQlxmIOYmn/Mvi/AGL+5sVxF\n" +
            "/DLIManW4q7E8EezDWN9EemsSifREhNvKAvUu5GIvJLxWSqE3ocdjHgG23AJ4nKSgjNRBbFiHEkY\n" +
            "VzKuEZGLcC/51otlSBiBDb8HfDmwHL1YiN+M21pKjQsxwL85tr0ItxSt/bjZoU3KN/qDpJutshL6\n" +
            "kG/24K/Ulm84tjua4VxCbDhh8FeyspjmeFEkJ/SBWQp83r4fDCbFJOstvz+LtBktDTAv4XjZiOEm\n" +
            "Mj9CnzHxnfWOCyLFntjKtIpJ959U/DTxeEomfLMifj+UIFOwLUK6C3h9BDl60QoLliJUEYGuxEgQ\n" +
            "bet2n/qBbY2CNMET1xdXD96KGDUAN1h896gI4yvKC1SOenXiiMFfeYELSesw+g40DqRVGGSZVSqb\n" +
            "kHroqbidlpc7aBuGNFkIY+ET6OXCWsRq1gp0DyLckFsAT1Km/5yHvZ9YsbRdQSoP5Jg1BmPyOtKf\n" +
            "R4xgZ0RQCmYZskQ5NLcgjtxJeDeXQRgk2EppAVU2k1IZxT6W3JeSr5c1bV9ixbL+XBOp372p6tkr\n" +
            "ShS2EueNaJD8uq6J2uYDnx/iOylSjE5lDi2bQdoeU1zd7BgJF6ayFTlx/zwSuTiKGAi2IzOAQZJO\n" +
            "n4i4uq9GMiv2YzkSt35jMKkHcypwD/rctAZDnFNh29xUK7APEzBIBpKUvIaWzSBNKV3gw8oIfU5D\n" +
            "ZoMRxEJ2TOeziT3PEH4OPIXbQ+ebaMKFpYnHUzJjKDcby9oMY65Civ4oLeBAyl0uvBE5w0nNTuDv\n" +
            "M4yrZOAjlKsg/5JpXINkaFRawD2UqyC55DZILZXW0OaDwgWUqyA5lzk7Mo6tJGSccp3uTs40bmrX\n" +
            "eiUjBslMXxqvzjh2qTOuM21dYlUnweuySuHGZbkFUJrPQsp9G34g49ilXjPFkl+h3Jud2r2k4nha\n" +
            "mKyhrUusP8wtgAe5sqq/PuPYSmK20cK3oSfX0sKqtm2dQWYhhTuV4TkMKcXWKtqqIADvzS1AYcyl\n" +
            "hfmw2qwgj+UWoDCOBR7JLYSShlItWDkZJY8HsZKYpaTNZdsUWvlSaeMS6z3AfbmFUMqgjQpyMnHC\n" +
            "bBWlEehhlxutXGK1Eb3RbrTyurVtiTUCbMktRIFo9puWMB94V24hCmQWLZ1B2sYa7MqbKcJsVEFa\n" +
            "gSZ6duMQyi5T50yb9iBHAtflFqJQ3okerjaalwN35BaiYG6ipd7PbZlBTkUzAvqwFPhKbiEUpa7s\n" +
            "Bt6cW4gctGUGUfwYoaV7EFUQZVhKTbKnKNExSMitoihdaO0hoS6xFKUPqiCK0gdVEEXpgyqIMgyt\n" +
            "TbKnCqIMYhEtdVQEVRBlMKfR4qpSqiDKIBYBP8gtRC5UQZRBLAAuyS2EotSVe3MLoCh1ZltuARSl\n" +
            "zrTWxKso/aiyv7TWDwt0k670pqoFMpZVCkWpMZcDV+YWQlEURVEURWkU/w+2urUSdCqh2gAAAABJ\n" +
            "RU5ErkJggg==";


    public static final String base64Url2 = "iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\n" +
            "CHwIZIgAAAb5SURBVHic7Z1bqFVFGIA/O6ZplGGZCZZIWtFRKYgerIfqIX2owIeyEioqEBE06Poi\n" +
            "UdBD95ciuhGZhoVmUBRW0J2uYKcySBPKykxLuxwv6Tln9zB7c9bZZ+2155/5Z2bvtfcHi73P7H/+\n" +
            "/1/zr9vM/LMOyDnNoU6XgFRSO1BmjkrtQBd/FgFHUjvRZSSdfNlaDvQBh4FDwGZgZVKPgFuBG1M7\n" +
            "EZk9mAOxgglEH/ARsDVTviOZd3TWWVIB9lvI7SNhu6xIZTgyA8DLAvmkB+qXKY1HQtrADwHTQjhi\n" +
            "w+RUhiPxOjDJod4WbUe6GFwvP4OqXgh5NqXxwLgGpJMeeKLyrWO9jghIip28yrFeNyAthrOv3cHF\n" +
            "xlyU2oFWR/sMGa+sL0s7nc3O+O7kPOBthsedatujnnrz6AakgJcYbvzdwAxgQvW3aR56i+gGJIc1\n" +
            "1Tr9wFxFvTZ0A5Khpyo7CFxsIR+iV90RAfnJQmYupjHOFOj9HbjcyaPGlD4gx2LXaC4NsQV4QEGP\n" +
            "Sv2xnobzmAnMAWYBx1XLhoADwMfAZw46dwInN5EZBKY46B4gTDtEZwVmPvkAox8lK8BfwPnASQq2\n" +
            "bI4416Pye+BmJV1a9ZsyFbiX/IavbQPAJ4Hs2+zggKPu/cAJDvaK8A7I0sz3hZgsivcpDkBtnvk+\n" +
            "X+MWhDzi6nWfo2DP299mDZ/d1gHn+hp08C+W7hUK9lQCMlTdspegfcBXvsoViBmQfgV7pX/sjRmQ\n" +
            "Ifw7i6Uefj8LWB3R3nLMY7YPQ64V2yEg84HrBfJrPe3tBJ7xqD+Gkuc+/yeU7xfITmf05eVJ3FJ/\n" +
            "atwEfO1aOcYZssGz/jihvOToXA88Vle2GL97Vi92aafJiP3Esk+oe2ZOmc9s4lvA1R71g/OiZ31p\n" +
            "QPZ66vY9gP7xrB+co4FTPepLG+gXT91J+yAx7iFHsMsB1uprPKekp9RsspCpYPoc9UhukIsEsjWb\n" +
            "NmW+Oq2J1Q/ZZimX97j4qsCOZMn2lcBvAvlSUZRkUGMC+UdX/VxFEbsEsj8Dp+eUl34c6xKBbF/d\n" +
            "308LbUkao5FsrXwe+QHT9CEJEgd7GNlL/iKgraKA1G/PB/IhCVIHszdm6TO9b0AW0ngeaAiYrexD\n" +
            "dBYgT7HJTsVKd843IBto3lNfruhDdFyc2+pRXyJ/KKesH9mKW18fouOS8pMdTJTu3GFLuTeBB3PK\n" +
            "Kwzn/boSLCBTqsrHONbXcEyiYw7wiKXsQQV7jQgWkAomG8XFQC/mtRMaPhSxG3PP2YWZWJrqqde3\n" +
            "Mcdj8ryCUKn7dKmr5UPR7/Xbvx56ff1+AbjNR0HR0MmYzOcdAp1rgHucPRpJswb6AeNfzdengD8w\n" +
            "s4zXKPkgYQGyGUtnNDpcLkimQvPsrhLIFpXb0o+5XAfHNk1zEDP/ocUSgaykMRv1vH0D4pxt4sKH\n" +
            "TX5fin/6TD0XCmRtG6MXOCWnfBv+o79R+yDNjGkfHT3YjRKDeUS3lV3XoLwCXGGpoxEtE5AQp+oU\n" +
            "RmelN+IWgd6i+4fvUumoAZkPnJdTPoD90SlBMg8vOSBC3dC1dHgZXIZZ+x2CGQJZzXkQH5IG5Bjc\n" +
            "F8nYsEwgK2mIRh3HtgzIpwwPvoU2/oFAVpII8VqD8krdd5eleElGemtrSEIjSXiTJGPnsYThfdrL\n" +
            "yEmpHoGeJAGJZTRmJ6sfeKf6/XZGj49dZqknekD2YrLDYxBz5+ptHWF0UGxGr6MGZGPm+4EI9lIG\n" +
            "pMZGRgal6G0S04n48stX6v6O0VitEJAaZ2ByhiuY9fd5XIBdhqY3ean1s7HLwPChlQKSZRP5i4hu\n" +
            "wH5kIQihGyxWQMY52lrNyPmk7Zh3siQj1FsbasQKyHu4L/3OJvW1RLaJ72KcIhrt4MHqb38DdynY\n" +
            "GcK8vcGXlgiIZHGMlEY7+A35c+kbyF/O4GoniR7XFJ8sizHvNdRGmoJ0NnApw5eRtZg5d207QfVo\n" +
            "vCfKN7FMi++qWxdMJqA2Ma7JJyraaYl7SBbtR74YO7gZeFdJV8sFZKKyvlijAbMUdZWaGKO9mo2o\n" +
            "oquVXz7TbkecysBiKwck5PRwCH7VUNLJARlL42UJLmzXUNLKAZFM4bqwCv/EuBq9mCe20jIRpSOu\n" +
            "AM3JpIdR+heCrXqGXAd8HtiG5r5PJvwZnZQ3MHlfIdF8irMZM2tr2q0Pkreit1TE6IPcr6ir3fpM\n" +
            "YtptB9X8bdWbesfSqQF5PLUD7cS1hL9kbW0uIqLdLrEiBjD/xzwk2k9FpQ6I1hx3ESuV9ZUuILV7\n" +
            "2STi7NzxyvpKF5D11c8K8GdKRyxYmlNWuoAA/Ej77lgp+yF9yF7zmpK7UzvQpZhSniHtxo7q551E\n" +
            "egNQl+bswZwd2v9Lt4sjT9C+DyKlRfX9WP8DJzX8ySbwq4QAAAAASUVORK5CYII=";


    public static final String base64Url3= "iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\n" +
            "CHwIZIgAAAdhSURBVHic7Z17iBVVGMB/tuu2uvSWNOhFhFlkb7KsiBLsRUjgn0UPKQSzzKjohUQR\n" +
            "hT0IiiiMIBLUWMWkoCAlk4gsRYkeZLQRZT7SHrp63fVOf5y93ml2Zu55fGfO7HV+sOzu3HO+75vz\n" +
            "zTlzznceFyrailtDG9BuHOGYvwN4QcKQChluD21Au+FaQ2oCMloReZbfVkwAHvOso3KIIV96ll85\n" +
            "xBCfBbbSs/y2xGeBHfQsv3RIvJB/FJCRhe8OQ1vSCTztUf5hVUOkGPQou3KIBbd4lF05pGSMRIdM\n" +
            "RUUxlgB/AQNAHzCuVcZOr2YdXowHNgInxa71AStQTfrRwA5gVOGWCTMSasg6lJ39wAM56doiEFt2\n" +
            "h0SoJukMzfQTPdpSCGV2SB1Yb5hnnQ9DiqSsDlkN/G6Rb5+0IUVTRod0YG/XAUlDQlBGh7jYdDDv\n" +
            "wypWZMdPDnlL0e0dC0yzzLtf0pAcLgBu1ki31lFPYTV+JmoQtB3V+4hyfr41kPuVrJmHeA/VnqfZ\n" +
            "l/cQbHPU680hz6C6fHkFfwD4AXgDmAFcb6HnSQljYzxL074FwLXAsYk0K4HPhPU2GJAS1Al8SvrT\n" +
            "Pwg8B1wGdEkpHOI0QVl3oOy9UiNt8kmOUI5y4REEavwnpD/984AzXYVrcLKgrAj1PtNhSezvWiy/\n" +
            "C9uAK2wyrqU5fRqvBec7GmSDbgHq8Ldh+hOHfp869NvVIXtMEs9EjSKTTjjPQvFuzIy/zkKHLRsN\n" +
            "0t6Q+H+5o+66bsJHaTphALd2OwKmAJsM8vQ76DPF5EH5LpTuncBTAgrfAnqG/jYJuhU5GjfR9UfK\n" +
            "tdUF6RZHu3qSbegECUM0daWRNh75x6dun6ETiRDBbQIyXEi7hzGFWyHAFMw6A1nvEJfmIQuTGlJL\n" +
            "uebS7ARrskwVb8+4Lv1SBTPbfnPML5nXmjGkP1l5LMi4vtvRljRMCuVqx/xxOtBYv+Zj1Uk/5u+P\n" +
            "LEN7Mq4Xxb+CsnpRvdBCmYTdjNjUjOs+qriuzIsd8yfpA46xzGuNdAGGdMgKx/xJDgCjLfNa8RHZ\n" +
            "L+c88prNkA7JmhMxGV/Z6BWhy0Hh3Tmfic0dxNC1Myud7XtFS6/UwLAG3GmZ99Kcz76xlJlH7iID\n" +
            "DX4VsUKTVShPmvRu5uB2k3k3+JCD3Cx2aKbLeqJte35WLUhEc0KqQyP9KFtFMe7P+Ux6/qUbdX86\n" +
            "/JJybZGDbqtyumno9+uaAuqoaV1fnCUsb5JB2rT5/6Cj9D7gw5zPZ0koaUHL/RSG/KmZ7mzSW4jg\n" +
            "YZMsIRJNlQ7Si8p0bV7qmF867yHGZAiqA4slFBSMbqFkhXKCOwRUlzbens7BfnAUGtcxSF7+6cD7\n" +
            "/H+ZVHzLuGt3O9OQMi5+1kX3QUq7x7uAexPX5gK7aDpgE2qLeHKmcyLwsb6ZrVmIWnFRx8/YoCh0\n" +
            "w/lpXd54KGUzygE/oxa/taIXuERTtzaNpaEjGd1FajNSrjVqTRfpDstjPXCKYZ6WRKgtvkVxubA8\n" +
            "3RjU3IzrLk31LoRD7zXUorEIOFJScA5PCMvTLdANjvnTEA2STqbZWxhNcT2st4XlufSw7kE95b51\n" +
            "WwnbAMyXVJDBB8LyXByyF7fpZDGHbPGtIIc1grLGogZ78XXLW4BzU9KmdVxc71ekvE4Absz4bDZm\n" +
            "a3dtMFkU3YoI1XO6iOYMZTdq3vzlRNr7MvK76ndmYRFKcpCcnNK1tQv5oKJEft7USDMO9/12efQJ\n" +
            "ytLtiDyccm0D9rOhDZwcMr4oRS2wOSUhC90BbdoO2wj3qe7Cwk3d+FldCG7dzCTHaaZLGy9IFGah\n" +
            "8T/RKGYMmyVFrqQVnERhaoecJFadjMZtz0QWIZb9J8c+y4HvBeSKRnp1MF1crYPUqTmrDNImz7yq\n" +
            "4x4qeokwm2XZKSxP6kiNCx3ypjVXVwHLgK2o92eN4Xv347avAU53sMGazcLyyhDqT9ufn/wZRO1j\n" +
            "mYaK6M6m6aBOVNglGC8KyvJ5FrAOS3E79QdUqxF0hrVXUFZoh0hNNQSf8r5GSE7oJkuqII3k+NiF\n" +
            "61rNG4zUlS2lROe0nVb46Errsgy5aHbwJisPk7W1Id8hjR6SlKzSYnKTIZssqUI8gvCdk5a8ht50\n" +
            "aMgnS0r3IuBxIVleeRC1VilvE2SoGvIK8I6QrL3AOSYZQh5ZOh21UfQL1LmHydhVhJx9R6Em1I5H\n" +
            "zQjuQx0m1oU6E9KXXklZhbEVZXhy/sOl2dhD9smo/agobndGXsmmstQv9Dyep1lgjV1cLjdTR23O\n" +
            "6cX8tLrKITH6UTcxQLibeVdQ1oh3CDT3N/rYo96KHmTPf2kLh4RknqCsxeit3qnIQXJHcQ3DLm/F\n" +
            "cCTjZ1VzJcAsQVmVQ0qGlUOqL3SxY3JoAyqGMz3ns1eBr4sypKLJ5xnX9+O2/KjCAR8bfCocmM/w\n" +
            "VfOVQwKTdIC1Q6pelgyDNE/Brt4dJaCHZq1YQfZJ3RUFEqHmzyNkv6apwpL4d3ZVlIDGYW+VQ0qE\n" +
            "s0OqXpYsRX65WYUmTlsY/gNhuvQY1qL55AAAAABJRU5ErkJggg==";
}
